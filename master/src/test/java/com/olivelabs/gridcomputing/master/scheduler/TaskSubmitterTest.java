package com.olivelabs.gridcomputing.master.scheduler;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.olivelabs.gridcomputing.common.executor.Executor;
import com.olivelabs.gridcomputing.common.executor.TestExecutor;
import com.olivelabs.gridcomputing.common.task.Job;
import com.olivelabs.gridcomputing.common.task.TestJob;

public class TaskSubmitterTest {
	
	private TaskSubmitter taskSubmitter;
	private Scheduler scheduler;
	private List<Executor> executors = new ArrayList<Executor>();
	private final long EXEC_COUNT=2l;
	private Job job;
	
	
	@Before
	public void setUp(){
		this.job = new TestJob();
		this.taskSubmitter = new TaskSubmitter();
		this.scheduler  = this.taskSubmitter.getScheduler();
		Executor executor = null;
		for(int i = 0; i<EXEC_COUNT; i++){
			executor = new TestExecutor();
			executors.add(executor);
		}
		this.taskSubmitter.getScheduler().setExecutors(executors);
		this.taskSubmitter.addJob(job);
	}

	@Test
	public void testAddJob() {
		
		Assert.assertTrue(this.taskSubmitter.getJobCount()==1);
	}

	@Test
	public void testDipatchJob() throws RemoteException {
		this.taskSubmitter.dipatchJob();
		Job job = this.taskSubmitter.getDispatchedJob();
		Assert.assertNotNull(job);
		Assert.assertNotNull(job.getResultAggregator());
		Assert.assertNotNull(job.getResultAggregator().getAggregatedResults());
		
	}
	
	@After
	public void tearDown(){
		
	}

}
