package com.olivelabs.gridcomputing.common.executor;

import java.util.ArrayList;
import java.util.List;

import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.result.Result;

public class TestResultAggregator implements ResultAggregator {

	List<Result> results = new ArrayList<Result>();
	
	public void aggregate(Result result) {
		results.add(result);
	}

	public Object getAggregatedResults() {
		// TODO Auto-generated method stub
		return results;
	}

	
}
