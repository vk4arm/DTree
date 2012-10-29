package com.vk.learning.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7576080590884473155L;


	private  String attribute;
	
	
	private String className = null;
	private int conditionType;
	private  List <String> values = new ArrayList<String>();
	
	private Node parentNode = null;
	private List<Node> childen = new ArrayList<Node>();
	
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public int getConditionType() {
		return conditionType;
	}
	public void setConditionType(int conditionType) {
		this.conditionType = conditionType;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValue(List <String> values) {
		this.values = values;
	}
	public void addValue(String value) {
		this.values.add(value);
	}
	
	public Node getParentNode() {
		return parentNode;
	}
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	
	public List<Node> getChilden() {
		return childen;
	}
	
	public void setChilden(ArrayList<Node> childen) {
		this.childen = childen;
	}
	
	public void addChild(Node child){
		this.childen.add(child);		
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

}
