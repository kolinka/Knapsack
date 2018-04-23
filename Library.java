package first;

import java.util.HashSet;

import org.jorlib.alg.knapsack.BinaryKnapsack;

public class Library {

	public static Result library(Instance instance){
		long startNanoTime = System.nanoTime();
		
		int n = instance.getNumberOfItems();
		int maxkWeight = instance.getMaxWeight();
		double[] values = instance.getValues();
		int[] weights = instance.getWeights();
			    
	    Result result = new Result();
		result.setNumberOfItems(n);

	    BinaryKnapsack knapsack=new BinaryKnapsack();
	    knapsack.solveKnapsackProblem(values.length, maxkWeight, values, weights);
	    
	    result.setValue(knapsack.getKnapsackValue());
	    result.setWeight(knapsack.getKnapsackWeight());
	    result.setSolution(knapsack.getKnapsackItems());
	    
	    HashSet<Integer> packedItems = new HashSet<Integer>();
		for(int i=0; i<n; ++i)
			if(knapsack.getKnapsackItems()[i]==true)
				packedItems.add(i+1);
		result.setPackedItems(packedItems);
	    
		long estimatedTime = System.nanoTime() - startNanoTime;
		result.setRuntime(estimatedTime);  
		
		return result;
	   
		}
}
