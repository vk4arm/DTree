package com.vk.learning.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private  String attribute;
	
	
	
	private int conditionType;
	private  String value;
	
	private Node parentNode = null;
	private List<Node> childen = null;
	
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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

}
