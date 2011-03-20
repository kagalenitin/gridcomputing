package com.olivelabs.gridcomputing.common.task;

import java.util.List;

import com.olivelabs.gridcomputing.common.executor.ResultAggregator;
import com.olivelabs.gridcomputing.common.result.Result;

public interface Job {
	public List<Task> getTasks();
	public void dispatch();
	public ResultAggregator getResultAggregator();
}
