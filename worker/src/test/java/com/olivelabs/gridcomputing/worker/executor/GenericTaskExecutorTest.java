package com.olivelabs.gridcomputing.worker.executor;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.executor.TestResultAggregator;
import com.olivelabs.gridcomputing.common.task.Task;
import com.olivelabs.gridcomputing.common.task.TestTask;

public class GenericTaskExecutorTest {

	private GenericTaskExecutor executor;
	private Task task;
	private ResultAggregator resultAggregator;
	@Before
	public void setUp() throws Exception {
		executor = new GenericTaskExecutor();
		task = new TestTask();
		resultAggregator  = new TestResultAggregator();
		executor.unRegister();
		executor.register(resultAggregator);
	}
	
	@Test
	public void testExecute() throws RemoteException{
		executor.executeTask(task);
		
	}

	@Test(expected=RuntimeException.class)
	public void testExecuteException() throws RemoteException{
		executor.unRegister();
		executor.executeTask(task);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
