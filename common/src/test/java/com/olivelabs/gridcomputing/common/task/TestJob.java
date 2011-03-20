package com.olivelabs.gridcomputing.common.task;

import java.util.ArrayList;
import java.util.List;

import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.executor.TestResultAggregator;

public class TestJob implements Job{

	private List<Task> tasks;
	private ResultAggregator resultAggregator;
	private final long JOB_COUNT=10l;
	
	public TestJob(){
		super();
		tasks = new ArrayList<Task>();
		for(int i=0;i<JOB_COUNT;i++){
			Task task = new TestTask();
			tasks.add(task);
		}
		resultAggregator = new TestResultAggregator();
	}
	
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return tasks;
	}

	public void dispatch() {
		
		
	}

	public ResultAggregator getResultAggregator() {
		// TODO Auto-generated method stub
		return resultAggregator;
	}

}
