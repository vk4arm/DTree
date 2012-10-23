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
		
		
		
		
	}
	
	private void createTree(List<Incident> trSet, Node rootNode){
		
		// Find the best attribute
		// Calculation information gain for each
		// Attribute value
		Map cCounter = calcClassFreqMap(trSet);
		Double entropy = calcEntropy(cCounter, trSet.size());
		String bestAttr = getBestAttribute(trSet, entropy);
		
	}
	
	
	private String getBestAttribute(List<Incident> trSet, Double entropy) {
		
		Map <String, AttrSliceTable> sliceTable = new HashMap();
		
		Iterator<Incident> it = trSet.iterator();
		Incident inc = null;
		Iterator <String> intit = null;
		String attr;
		AttrSliceTable recordT;
		Pair pair;
		
		// Unique Attributes in the training set
		while(it.hasNext()){
			inc = it.next();
			intit = inc.getData().keySet().iterator();
			while(intit.hasNext()){
				attr = intit.next();
				recordT = sliceTable.get(attr);
				if(recordT==null){					
					recordT = new AttrSliceTable();
					recordT.setAttrName(attr);
					pair = new Pair(inc.getData().get(attr).toString(), inc.getcName());
					
					recordT.getValToClassTable().add(pair);
					sliceTable.put(attr, recordT);
				}
			}
		}
		Iterator<String> attrIter = sliceTable.keySet().iterator();
		
		while(attrIter.hasNext()){
			recordT = sliceTable.get(attrIter.next());
			
			
		}
		
		
		
		
		
		return attrs;
		
	}

	private Map calcClassFreqMap(List trSet){
		Iterator<Incident> it = trSet.iterator();
		HashMap<String, Integer> cCounter = new HashMap<String, Integer>();
		Incident in = null;
		while(it.hasNext()){			
			in = it.next();
			if(!cCounter.containsKey(in.getcName())){
				cCounter.put(in.getcName(), 1);				
			} else {				
				cCounter.put(in.getcName(), 1+(int)cCounter.get(in.getcName()));
			}						
		}
		return cCounter;
		
	}

	private double calcEntropy(Map cCounter, int num){
		double entropy = 0;
		Iterator<Integer> it = cCounter.values().iterator();
		while(it.hasNext()){
			double probability = (double)it.next()/num;
			entropy -= probability * log2(probability);
		}
		return entropy;
	}
	
	
	
	private double informationGain(){
		
		
		
	}

}
