package com.vk.learning;

import java.util.ArrayList;
import java.util.List;

import com.vk.learning.tree.Node;

import redis.clients.jedis.Jedis;

@SuppressWarnings("unused")
public abstract class DTree implements LearnInterface {

	
	protected List<Incident> trainingSet;
	protected Node rootNode = null;
	

	private String prefix = "dtree";
	private String redisHost = "localhost";
	private int redisDb = 0;
	
	private final double log2 = Math.log(2);
	
	
	
	/**
	 * Default constructor
	 */
	public DTree() {
		super();
	}

	/**
	 * Constructor with redis connection data
	 */

	public DTree(String prefix, String redisHost, int redisDb) {
		super();
		this.prefix = prefix;
		this.redisHost = redisHost;
		this.redisDb = redisDb;
	}	
	

	
	@Override
	public int addExample(Incident incident) {
		this.trainingSet.add(incident);
		return this.trainingSet.size();
	}

	public void setExamples(List<Incident> trainingSet) {
		this.trainingSet = trainingSet;
	}
	
	public List<Incident> getTrainingSet() {
		return trainingSet;
	}



	@Override
	public void cleanExamples() {
		this.trainingSet.clear();
	}

	
	
	@Override
	public boolean train() {
		// Should be redefined
		return false;
	}

	@Override
	public boolean save(String prefix) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String resolve(Incident incident) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean load(String prefix) {
		// TODO Auto-generated method stub
		return false;
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
		
	}

		
	protected double log2(double n){		
		return Math.log(n)/this.log2;		
	} 
	
	
	
	

}
