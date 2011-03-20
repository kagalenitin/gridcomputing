package com.olivelabs.gridcomputing.common.task;

import java.util.HashMap;
import java.util.List;

import com.olivelabs.gridcomputing.common.result.Result;

public interface Task {
	
	public Long getId();
	public Job getParent();
	public HashMap<String, Object> getData();
	public void setData(HashMap<String, Object> data);
	public void addData(String name, Object value);
	public void removeData(String name);
	public Result execute();
	
}
