package com.olivelabs.gridcomputing.common.executor;

import com.olivelabs.gridcomputing.common.result.Result;

public interface ResultAggregator {
	public void aggregate(Result result);
	public Object getAggregatedResults();
}
