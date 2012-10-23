package com.vk.learning;

import java.io.Serializable;
import java.util.Map;

/*
 * Incident for training set
 */
public class Incident {
	
	
	private Map<String, Serializable> data;
	private String cName;
	
	
	public Incident(Map<String, Serializable> data, String cName) {
		
		this.data = data;
		this.cName = cName;
	}
	
	
	public Map<String, Serializable> getData() {
		return data;
	}
	public void setData(Map<String, Serializable> data) {
		this.data = data;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
}
