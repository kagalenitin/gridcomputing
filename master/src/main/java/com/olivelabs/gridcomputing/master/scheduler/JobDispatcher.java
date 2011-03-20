package com.olivelabs.gridcomputing.master.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.olivelabs.gridcomputing.common.task.Job;

public class JobDispatcher {

	private List<Job> jobs = new ArrayList<Job>();
	
	public synchronized void addJob(Job job){
		this.jobs.add(this.jobs.size(),job);
	}
	
	public synchronized Job getNextJob(){
		return this.jobs.remove(0);
	}
	
	public long getJobListSize(){
		return this.jobs.size();
	}
	
}
