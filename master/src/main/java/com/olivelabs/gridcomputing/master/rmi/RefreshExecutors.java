package com.olivelabs.gridcomputing.master.rmi;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

import com.olivelabs.gridcomputing.common.executor.Executor;

public class RefreshExecutors implements Runnable {

	private HashMap<String, Object> executors;
	
	public RefreshExecutors(HashMap<String, Object> executors){
		this.executors = executors;
	}
	
	public void run() {
		try {
            Registry registry = LocateRegistry.getRegistry();
            String[] executorNames = registry.list();
            for(String executorName : executorNames){
            	if(executorName!=null && executorName.substring(0, 6).equals("WORKER")){
            		Executor executor = (Executor)registry.lookup(executorName); 
            		if(!executors.containsKey(executorName)){
            			System.out.println("Appending executor : "+executorName);
            			executors.put(executorName, executor);
            		}
            		
            	}
            }
            
           
        }
        catch(Exception e) {
            e.printStackTrace();
        }
	}

}
