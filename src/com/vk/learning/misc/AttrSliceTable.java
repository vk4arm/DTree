package com.vk.learning.misc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class AttrSliceTable {
	
	private String attrName;
	private List<Pair> valToClassTable;
	private Map<String, String> convolution;
	
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public List<Pair> getValToClassTable() {
		return valToClassTable;
	}
	public void setValToClassTable(List<Pair> valToClassTable) {
		this.valToClassTable = valToClassTable;
	}

	/**
	 * 
	 */

	public void makeConvolution(){
		Pair convoPair = new Pair();
		
		for(Pair pair: valToClassTable){
			//convoPair = convolution.get();
			
		}
	}

	

	

}
