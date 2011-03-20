package com.olivelabs.gridcomputing.common.task;

import java.util.HashMap;

import com.olivelabs.gridcomputing.common.result.Result;
import com.olivelabs.gridcomputing.common.task.Task;

public class TestResult implements Result {

	private Task task;
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	public void setTask(Task task) {
		this.task = task;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public Task getTask() {
		// TODO Auto-generated method stub
		return task;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void addData(String name, Object value) {
		this.data.put(name, value);
	}

	public void removeData(String name) {
		this.data.remove(name);
	}

}
