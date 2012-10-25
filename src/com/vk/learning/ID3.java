package com.vk.learning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vk.learning.misc.AttrSliceTable;
import com.vk.learning.misc.Pair;
import com.vk.learning.tree.Node;
import com.vk.learning.Incident;

public class ID3 extends DTree {
	
	private final double log2  = log2(2.0);
	
	@Override
	public boolean train() {

		createTree(this.trainingSet, this.rootNode);
		
		return false;
		
		
	}
	
	private void createTree(List<Incident> trSet, Node rootNode){
		
		// Find the best attribute
		// Calculation information gain for each
		// Attribute value
		Map<String, Integer> cCounter = calcClassFreqMap(trSet);
		Double entropy = calcEntropy(cCounter, trSet.size());
		String bestAttr = getBestAttribute(trSet, entropy);
		
	}
	
	
	private String getBestAttribute(List<Incident> trSet, Double entropy) {
		
		Map <String, AttrSliceTable> sliceTable = new HashMap<String, AttrSliceTable>();
		
		AttrSliceTable recordT;
		Pair pair;
		
		// Unique Attributes in the training set
		for(Incident inc: trSet){			
			for (String attr: inc.getData().keySet()){
				
				
				
				if(sliceTable.containsKey(attr)){
					recordT = sliceTable.get(attr);
				} else {					
					recordT = new AttrSliceTable();
					recordT.setAttrName(attr);
				}
				
				pair = new Pair(inc.getData().get(attr).toString(), inc.getcName());					
				recordT.getValToClassTable().add(pair);
				sliceTable.put(attr, recordT);
				
			}
		}
		Iterator<String> attrIter = sliceTable.keySet().iterator();
		
		for(String attr: sliceTable.keySet()){
			recordT = sliceTable.get(attr);
		}
		
		
		
		
		
		return "test";
		
	}

	/**
	 * calcClassFreqMap
	 * @param trSet
	 * @return
	 * 
	 * a,a,a,b,c,d -> a:3, b:1, c:1, d:1
	 * 
	 * 
	 */
	private Map<String, Integer> calcClassFreqMap(List<Incident> trSet){

		Map<String, Integer> cCounter = new HashMap<String, Integer>();
		
		for(Incident in: trSet){									
			if(!cCounter.containsKey(in.getcName())){
				cCounter.put(in.getcName(), 1);				
			} else {				
				cCounter.put(in.getcName(), 1+(int)cCounter.get(in.getcName()));
			}			
		}
		return cCounter;
	}

	/**
	 * Entropy calculation
	 * @param cCounter
	 * @param num
	 * @return
	 */
	private double calcEntropy(Map<String, Integer> cCounter, int num){
		double entropy = 0;
		for(Integer val: cCounter.values()){
			double probability = (double)val/num;
			entropy -= probability * log2(probability);
		}
		return entropy;
	}
	
	
	
	@SuppressWarnings("unused")
	private double informationGain(){
		return (Double) null;
		
		
	}

}
