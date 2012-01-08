package com.ideaimpl.patterns.pipeline.samples.numbermagic;

import com.ideaimpl.patterns.pipeline.Pipeline;
import com.ideaimpl.patterns.pipeline.CancellableSequentialPipeline;

/**
 * A sample client class to demonstrate the usage of Pipeline Pattern
 * 
 * Takes an array of integers as input and does the following 
 * calculate the product of all numbers
 * Increase each value in the array by adding the product
 * sort the numbers
 * the sorted list is returned
 * @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */

public class NumberMagicWithProduct {
	
	private static  final Pipeline S_PIPELINE = new CancellableSequentialPipeline();
	
	static{
		S_PIPELINE.addStage(new GetProductStage ());
		S_PIPELINE.addStage(new IncreaseValueStage ());
		S_PIPELINE.addStage(new SortStage ());
	}
	
	
	
	public int[]  doMagic(int[] numbers){
		NumberMagicContext nmContext = new NumberMagicContext ();
		nmContext.setInput(numbers);
		S_PIPELINE.execute(nmContext);
		return nmContext.getSortedValues();
	}

}
