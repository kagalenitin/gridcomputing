package com.olivelabs.gridcomputing.common.executor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.olivelabs.gridcomputing.common.task.Task;

public interface TaskExecutor extends Remote {
	public static final String SERVICE_NAME = "";

    Object executeTask(Task t) throws RemoteException;
}
