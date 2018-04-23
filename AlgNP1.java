package first;

import java.util.HashSet;

public class AlgNP1 {

	static Result algNP1(Instance instance) {
		long startNanoTime = System.nanoTime();	  

		int n = instance.getNumberOfItems();
		int maxWeight = instance.getMaxWeight();
		double[] values = instance.getValues();
		int[] weights = instance.getWeights();
		
		Result result = new Result();
		result.setNumberOfItems(n);

		double[][] partialKnapsackValues = new double[n+1][maxWeight+1];	//D[i][j] = max value of knapsack included in {0, ..., i-1} weighting at most j
		boolean[] solution = new boolean[n];			//solution[i] = 1, if ith item is in knapsack; 0 
		HashSet<Integer> packedItems = new HashSet<Integer>();
		
		int i,j;
		for(i=0; i<n; ++i) {
			solution[i] = false;
		}

		for(i=1; i<=n; ++i)
			for(j=1; j<=maxWeight; ++j) 
				 //impossible || not worthy to add item i (indexed by i-1)
				if(j-weights[i-1]<0 || partialKnapsackValues[i-1][j]>=partialKnapsackValues[i-1][j-weights[i-1]]+values[i-1]) {
					partialKnapsackValues[i][j]=partialKnapsackValues[i-1][j];
				}
				else { //we add item i
					partialKnapsackValues[i][j] = partialKnapsackValues[i-1][j-weights[i-1]]+values[i-1];
				}
		
		double value = partialKnapsackValues[n][maxWeight];	//optimal value of knapsack
		result.setValue(value);
		
		i=n-1;
		j = maxWeight;
		while(i>=0 && j>0) {
			if(partialKnapsackValues[i+1][j] != partialKnapsackValues[i][j]) {
				solution[i]=true;
				packedItems.add(i+1);
				j=j-weights[i];
			}
			i--;
		}
		result.setSolution(solution);	
		result.setPackedItems(packedItems);		
		result.setWeight(maxWeight-j);
		
		long estimatedTime = System.nanoTime() - startNanoTime;
		result.setRuntime(estimatedTime);
		
		return result;
	}
	

}
