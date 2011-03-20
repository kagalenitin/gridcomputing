package com.olivelabs.gridcomputing.common.executor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.olivelabs.gridcomputing.common.task.Task;

public interface Executor extends Node {
	
	void register(ResultAggregator aggregator);
	void unRegister();
    void executeTask(Task task) throws RemoteException;
}
