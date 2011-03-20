package com.olivelabs.gridcomputing.master.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.olivelabs.gridcomputing.common.executor.Executor;
import com.olivelabs.gridcomputing.master.scheduler.routing.RoutingAlgorithm;

public class Scheduler{

	private List<Executor> executors;
	private RoutingAlgorithm algorithm;
	
	public Scheduler(){
		this.executors = new ArrayList<Executor>();
		this.algorithm = new RoutingAlgorithm();
	}
	
	public synchronized void addExecutor(Executor executor){
		this.executors.add(executor);
	}
	
	public Executor getBestNode(){
		return this.algorithm.getBestNode(executors);
	}

	public List<Executor> getExecutors() {
		return executors;
	}

	public void setExecutors(List<Executor> executors) {
		this.executors = executors;
	}

	public RoutingAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(RoutingAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	
}
