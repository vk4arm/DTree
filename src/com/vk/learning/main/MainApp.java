/**
 * 
 */
package com.vk.learning.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vk.learning.ID3;
import com.vk.learning.Incident;


/**
 * @author victor
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ID3 id3 = new ID3();
		List<Incident> incidents = new ArrayList<Incident>();
		// 10 examples for training set test!
		Map<String, Serializable> data = new HashMap<String, Serializable>();
		data.put("like-brand", "dolche-gabana");
		data.put("weight", "small");
		data.put("height", "small");
		data.put("like-gender", "male");
		incidents.add(new Incident(data, "female"));
		

		data = new HashMap<String, Serializable>();
		data.put("like-brand", "adidas");
		data.put("weight", "medium");
		data.put("height", "small");
		data.put("like-gender", "male");
		incidents.add(new Incident(data, "female"));

		data = new HashMap<String, Serializable>();
		data.put("like-brand", "mersedes");
		data.put("weight", "big");
		data.put("height", "medium");
		data.put("like-gender", "male");
		incidents.add(new Incident(data, "female"));

		data = new HashMap<String, Serializable>();
		data.put("like-brand", "dolche-gabana");
		data.put("weight", "small");
		data.put("height", "medium");
		data.put("like-gender", "female");
		incidents.add(new Incident(data, "female"));
		
		data = new HashMap<String, Serializable>();
		data.put("like-brand", "mersedes");
		data.put("weight", "medium");
		data.put("height", "medium");
		data.put("like-gender", "female");
		incidents.add(new Incident(data, "male"));
		
		data = new HashMap<String, Serializable>();
		data.put("like-brand", "adidas");
		data.put("weight", "big");
		data.put("height", "big");
		data.put("like-gender", "female");
		incidents.add(new Incident(data, "male"));

		data = new HashMap<String, Serializable>();
		data.put("like-brand", "mersedes");
		data.put("weight", "medium");
		data.put("height", "big");
		data.put("like-gender", "female");
		incidents.add(new Incident(data, "male"));

		data = new HashMap<String, Serializable>();
		data.put("like-brand", "dolche-gabana");
		data.put("weight", "big");
		data.put("height", "big");
		data.put("like-gender", "male");
		incidents.add(new Incident(data, "male"));

		data = new HashMap<String, Serializable>();
		data.put("like-brand", "dolche-gabana");
		data.put("weight", "small");
		data.put("height", "small");
		data.put("like-gender", "female");
		incidents.add(new Incident(data, "female"));

		data = new HashMap<String, Serializable>();
		data.put("like-brand", "adidas");
		data.put("weight", "medium");
		data.put("height", "medium");
		data.put("like-gender", "female");
		incidents.add(new Incident(data, "female"));

		System.out.println("Training set is:" + incidents + "\n\n");
		
		id3.setExamples(incidents);
		
		System.out.println("Start training...");
		
		id3.train();
		System.out.println("Tree is completed! Root Node=" + id3.getRootNode());
		
		
	}

}
