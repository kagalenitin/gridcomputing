package com.olivelabs.gridcomputing.worker.executor;

import java.rmi.RemoteException;

import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.executor.Executor;
import com.olivelabs.gridcomputing.common.result.Result;
import com.olivelabs.gridcomputing.common.task.Task;

public class GenericTaskExecutor implements Executor{
	private String SERVICE_NAME = "TaskExecutor";
	private ResultAggregator aggregator;
	private long count;
	public GenericTaskExecutor(){
		super();
	}

	public void register(ResultAggregator aggregator) {
		this.aggregator = aggregator; 
	}

	public void unRegister() {
		this.aggregator = null;
	}

	public void executeTask(Task task) throws RemoteException {
		if(aggregator == null)
			throw new RuntimeException(SERVICE_NAME + ": Please register the aggregator...");
		Result result = task.execute();
		aggregator.aggregate(result);
		count++;
	}

	public Double getMetrics() {
		return count * 1.0;
	}
	
	
	

}
