package com.vk.learning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vk.learning.misc.AttrSliceTable;
import com.vk.learning.misc.Pair;
import com.vk.learning.tree.Node;
import com.vk.learning.Incident;

public class ID3 extends DTree {
	
	
	
	@Override
	public boolean train() {

		createTree(this.trainingSet, this.rootNode);
		
		return true;
		
		
	}
	
	/**
	 * Main recursive method for tree building. Each branch is for maximum information gain
	 * @param trSet
	 * @param rootNode
	 */
	private Node createTree(List<Incident> trSet, Node rootNode){
		
		// Find the best attribute
		// Calculation information gain for each
		// Attribute value
		
		Map<String, Integer> cCounter = calcClassFreqMap(trSet);
		Double entropy = calcEntropy(cCounter, trSet.size());
		String bestAttr = getBestAttribute(trSet, entropy);
		
		Node currentNode = new Node();
		
		if(rootNode != null){
			currentNode.setParentNode(rootNode);
			rootNode.addChild(currentNode);
		} else 
			setRootNode(currentNode);
		
		currentNode.setAttribute(bestAttr);
		
		Map<String, List<Incident>> branches = makeBrahcnes(trSet, bestAttr);
		
		for(String val: branches.keySet()){
			Set <String> classesPerVal = new HashSet<String>();
			for(Incident inc:  branches.get((String) val)){
				classesPerVal.add(inc.getcName());
			}
			
			currentNode.addValue(val);
			if(classesPerVal.size()>1){
				// Continue recursion!
				createTree(
						removeSelectedAttr(
									branches.get((String) val), 
									bestAttr
									), 
						currentNode);
				
			} else 
				currentNode.setClassName(bestAttr);
			
			
		}
		return currentNode;
		
		
	}
	
	/**
	 * Remove from the training set data with the selected best attribute
	 * @param list
	 * @param bestAttr
	 * @return
	 */
	private List<Incident> removeSelectedAttr(List<Incident> list,
			String bestAttr) {
		// TODO Auto-generated method stub
		
		List<Incident> result = new ArrayList<Incident>();
		
		for(Incident inc: list){
			inc.getData().remove(bestAttr);
			result.add(inc);
		}
		
		return result;
	}
	
	

	private Map<String, List<Incident>> makeBrahcnes(
											List<Incident> trSet,
											String bestAttr
											) {
		Map <String, List<Incident>> result = new HashMap<String, List<Incident>>();
		for(Incident inc: trSet){
			Map<String, Serializable> data = inc.getData();
			String val = (String) data.get(bestAttr);
			if(!result.containsKey(val))
				result.put(val, new ArrayList<Incident>());
			result.get(val).add(inc);
		}
		
		return result;
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
				
				// Value to class for selected attribute
				pair = new Pair(inc.getData().get(attr).toString(), inc.getcName());					
				recordT.getValToClassTable().add(pair);
				sliceTable.put(attr, recordT);
				
			}
		}
		// sliceTable - classes per attributes - complete here
		
		
		Double attrEntropyDelta;
		Map <String,Double> attrInformationGain = new HashMap<String, Double>();
		
		for(String attr: sliceTable.keySet()){
			attrEntropyDelta = (double)0;
			recordT = sliceTable.get(attr);
			recordT.makeConvolution();
			
			for(String val: recordT.getConvolution().keySet()){
				// val - values in convolution map
				
				attrEntropyDelta  += (						
						Double.valueOf(recordT.getValNums().get(val)))/trSet.size()
						
						* calcEntropy(						
								recordT.getConvolution().get(val), 
						recordT.getValNums().get(val)
						);				
			}
			attrInformationGain.put(attr, entropy - attrEntropyDelta);
			
		}
		Double maxGain = (double)0;
		String winningAttr = new String();
		for(String attr: attrInformationGain.keySet()){
			if(attrInformationGain.get((String) attr)>maxGain){
				
				maxGain = attrInformationGain.get((String) attr);
				winningAttr = attr;
				
			}
		}
		
		return winningAttr;
		
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
