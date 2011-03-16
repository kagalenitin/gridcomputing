package com.olivelabs.gridcomputing.common.task;

import com.olivelabs.gridcomputing.common.result.SubResult;

public interface SubTask {
	public void execute();
	public SubResult getSubResult();
}
