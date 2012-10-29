package com.vk.learning.misc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class AttrSliceTable {
	
	private String attrName;
	private List<Pair> valToClassTable = new ArrayList<Pair>();
	private Map<String, Map<String, Integer>> convolution = new HashMap<String, Map<String, Integer>>();
	private Map<String,Integer> valNums = new HashMap<String,Integer>();
	
	public Map<String, Integer> getValNums() {
		return valNums;
	}
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
	 * Make convolution for class -> values
	 * + calculate valNums structure (number of each value)
	 */

	public void makeConvolution(){
		
		
		for(Pair pair: valToClassTable){
			if(!convolution.containsKey(pair.first))
				convolution.put((String)pair.first, new HashMap<String, Integer>());
			
			if(!valNums.containsKey(pair.first))
				valNums.put((String) pair.first, 1);
			else
				valNums.put((String) pair.first, 
						valNums.get(pair.first) + 1
						);
			
			if(!convolution.get(pair.first).containsKey(pair.second)){
				
				convolution.get(pair.first).put((String)pair.second,1);
				
			} else {
				convolution.get(pair.first).put(
						
						(String)pair.second,
						
						convolution.get(pair.first).get(pair.second)+1
						
						);
				
			}
		}
	}
	
	public Map<String, Map<String, Integer>> getConvolution() {
		return convolution;
	}


	

	

}
