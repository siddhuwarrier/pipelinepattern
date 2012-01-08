package com.ideaimpl.patterns.pipeline.samples.numbermagic;

/**
 * 
 * 
 *  @author Benoy Antony (benoy@ideaimpl.com) (http://www.ideaimpl.com)
 *
 */
public class Sample {
	
	public static void main (String[] args){
		 int[] numbers = {25, 10,  20 , 5};
		 
		 
		 int [] resultWithSum = new NumberMagicWithSum().doMagic(numbers);
		 
		 System.out.print ("Result for NumberMagicWithSum :");
		 
		 for (int number: resultWithSum){
			 System.out.print(number +" ");
		 }
		 
		 
		 int [] resultWithProduct = new NumberMagicWithProduct().doMagic(numbers);
		 
		 System.out.print ("\n\rResult for NumberMagicWithProduct :");
		 for (int number: resultWithProduct){
			 System.out.print(number +" ");
		 }
		 		 

	}

}
