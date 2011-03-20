package com.olivelabs.gridcomputing.common.executor;

import java.rmi.RemoteException;

import com.olivelabs.gridcomputing.common.executor.Executor;
import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.task.Task;

public class TestExecutor implements Executor {

	private long count = (long) (10 * ((Math.random()*100) % 10));
	
	public Double getMetrics() {
		return count * 1.0;
	}

	public void register(ResultAggregator aggregator) {
		// TODO Auto-generated method stub

	}

	public void unRegister() {
		// TODO Auto-generated method stub

	}

	public void executeTask(Task task) throws RemoteException {
		count ++;
		System.out.println("Executing task..");
	}

}
