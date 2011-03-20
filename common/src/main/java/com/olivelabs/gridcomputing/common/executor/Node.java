package com.olivelabs.gridcomputing.common.executor;

import java.rmi.Remote;

public interface Node  extends Remote{
	public Double getMetrics();
}
