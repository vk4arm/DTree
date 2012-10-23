/**
 * Interface for some machine learning algorithms
 */
package com.vk.learning;

import com.vk.learning.Incident;
import java.util.HashMap;

/**
 * @author victor kuriashkin, 2012
 *
 */
public interface LearnInterface {

	
	
	public int addExample(Incident incident);
	
	public void cleanExamples();
	
	public boolean train();
	
	public boolean save(String prefix);
	
	public String resolve(Incident incident);
	
	public boolean load(String prefix);
	
	
	
}
