package com.olivelabs.gridcomputing.common.task;

import java.util.HashMap;

import com.olivelabs.gridcomputing.common.result.Result;
import com.olivelabs.gridcomputing.common.task.Job;
import com.olivelabs.gridcomputing.common.task.Task;

public class TestTask implements Task {

	HashMap<String, Object> data = new HashMap<String, Object>();
	
	public Long getId() {
		return (long) (Math.random()*100)/10;
	}

	public Job getParent() {
		return null;
	}

	public HashMap<String, Object> getData() {
		// TODO Auto-generated method stub
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public void addData(String name, Object value) {
		this.data.put(name, value);
	}

	public void removeData(String name) {
		this.data.remove(name);

	}

	public Result execute() {
		System.out.println("Executing Task.. (returning dummpy data)..");
		Result result = new TestResult();
		result.addData("TestName", "TestValue");
		return result;
	}

}
