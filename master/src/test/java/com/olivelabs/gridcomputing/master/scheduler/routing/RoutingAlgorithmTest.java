package com.olivelabs.gridcomputing.master.scheduler.routing;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.olivelabs.gridcomputing.common.executor.Executor;
import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.executor.TestExecutor;
import com.olivelabs.gridcomputing.common.task.Task;

public class RoutingAlgorithmTest {
	private RoutingAlgorithm algorithm;
	private List<Executor> executors = new ArrayList<Executor>();
	private Executor bestNode;
	@Before
	public void setUp(){
		
		algorithm  = new RoutingAlgorithm();
		
		Executor executor = null;
		for(int i = 0; i<10; i++){
			executor = new TestExecutor();
			executors.add(executor);
			if(bestNode == null)
				bestNode = executor;
			if(executor.getMetrics() < bestNode.getMetrics())
				bestNode = executor;
		}
	}
	
	@Test
	public void testGetBestNode(){
		Executor executor = algorithm.getBestNode(executors);
		Assert.assertEquals(bestNode.getMetrics(),executor.getMetrics());
	}
	
	@After
	public void tearDown(){
		algorithm = null;
	}

}
