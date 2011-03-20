package com.olivelabs.gridcomputing.common.result;

import java.util.HashMap;
import java.util.List;

import com.olivelabs.gridcomputing.common.task.Task;

public interface Result {
	public Long getId();
	public Task getTask();
	public void setTask(Task task);
	public void setData(HashMap<String, Object> data);
	public HashMap<String, Object> getData();
	public void addData(String name, Object value);
	public void removeData(String name);
}
