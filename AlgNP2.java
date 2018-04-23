package first;

import java.util.HashSet;

public class AlgNP2 {
	static double maxPrice = 0;

	public static Result algNP2(Instance instance) {
		long startNanoTime = System.nanoTime();	  

		int n = instance.getNumberOfItems();
		int maxWeight = instance.getMaxWeight();
		double[] values = instance.getValues();
		int[] weights = instance.getWeights();
		
		Result result = new Result();
		result.setNumberOfItems(n);
		
		int[] x = new int[n];
		boolean[] S = new boolean[n];
		HashSet<Integer> packedItems = new HashSet<Integer>();
		for(int i=0; i<n; ++i)
			x[i]=0;
		plecak(0, 0, n, maxWeight, x, S, values, weights);
		
		result.setValue(maxPrice);
		result.setSolution(S);
		
		for(int i=0; i<n; ++i)
			if(S[i]==true)
				packedItems.add(i+1);
		
		result.setPackedItems(packedItems);			
		
		long estimatedTime = System.nanoTime() - startNanoTime;
		result.setRuntime(estimatedTime);
		
		return result;
	}
		
	static void plecak (int l, int temp_weight, int n, int maxWeight, int[] x, boolean[] S, double[] values, int[] weights) {
		if (l>=n) {
			double price=0;
			for(int i=0; i<n; ++i) 
				price+=values[i]*x[i];
			if(price > maxPrice) {		//if permitted solution is better than previous
				maxPrice = price;
				for(int j=0; j<n; j++) {
					if(x[j]==1) 
						S[j]=true;
					else S[j]=false;
				}
			}
		}
		else {
			if (temp_weight + weights[l] <= maxWeight) {	//if solution is permitted
				x[l]=1;
				plecak(l+1, temp_weight + weights[l],n,maxWeight,x,S,values,weights);
			}
			x[l]=0;
			plecak(l+1, temp_weight,n,maxWeight,x,S,values,weights);
		}		
	}
}
