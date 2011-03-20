package com.olivelabs.gridcomputing.master.scheduler;

import java.rmi.RemoteException;
import java.util.List;

import com.olivelabs.gridcomputing.common.executor.Executor;
import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.task.Job;
import com.olivelabs.gridcomputing.common.task.Task;

public class TaskSubmitter {
	
	private Scheduler scheduler;
	private JobDispatcher incomingJobs;
	private JobDispatcher dispatchedJobs;
	
	public TaskSubmitter(){
		super();
		scheduler = new Scheduler();
		incomingJobs = new JobDispatcher();
		dispatchedJobs = new JobDispatcher();
	}
	
	
	
	
	public JobDispatcher getIncomingJobs() {
		return incomingJobs;
	}




	public void setIncomingJobs(JobDispatcher incomingJobs) {
		this.incomingJobs = incomingJobs;
	}




	public JobDispatcher getDispatchedJobs() {
		return dispatchedJobs;
	}




	public void setDispatchedJobs(JobDispatcher dispatchedJobs) {
		this.dispatchedJobs = dispatchedJobs;
	}




	public Scheduler getScheduler() {
		return scheduler;
	}


	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}


	public synchronized Long getJobCount(){
		return this.incomingJobs.getJobListSize();
	}
	
	public synchronized void addJob(Job job){
		incomingJobs.addJob(job);
	}
	
	public synchronized void dipatchJob() throws RemoteException{
		Job job = this.incomingJobs.getNextJob();
		List<Task> tasks = job.getTasks();
		for(Task task : tasks){
			Executor executor = getNextNodeFromScheduler();
			unRegisterResultAggregatorFromExecutor(executor);
			registerResultAggregatorWithExecutor(executor, job.getResultAggregator());
			submitTask(executor,task);
		}
		this.dispatchedJobs.addJob(job);
	}
	
	public synchronized Job getDispatchedJob(){
		return this.dispatchedJobs.getNextJob();
	}
	
	private Executor getNextNodeFromScheduler(){
		return this.scheduler.getBestNode();
	}
	
	private void submitTask(Executor executor, Task task) throws RemoteException{
		executor.executeTask(task);
	}
	
	private void registerResultAggregatorWithExecutor(Executor executor, ResultAggregator resultAggregator){
		executor.register(resultAggregator);
	}
	
	
	private void unRegisterResultAggregatorFromExecutor(Executor executor){
		executor.unRegister();
	}

}
