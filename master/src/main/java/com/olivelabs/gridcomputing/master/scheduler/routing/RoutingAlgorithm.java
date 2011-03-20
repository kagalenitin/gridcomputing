package com.olivelabs.gridcomputing.master.scheduler.routing;

import java.util.List;

import com.olivelabs.gridcomputing.common.executor.Executor;

public class RoutingAlgorithm {

	public Executor getBestNode(List<Executor> nodes) {
		Executor bestNode = null;
		for (Executor node : nodes) {
			if (bestNode == null) {
				bestNode = node;
			}
			else if (node.getMetrics() < bestNode.getMetrics()) {
				bestNode = node;
			}
		}
		return bestNode;
	}
}
