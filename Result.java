package first;

import java.util.Arrays;
import java.util.HashSet;

public class Result extends Instance{

	private double value;
	private int weight;
	private boolean[] solution;
	private long runtime;
	private HashSet<Integer> packedItems;
	
	public double sumValues(Instance instance) {
		double sum = 0;
		for(int i=0; i<numberOfItems; ++i)
			if(solution[i]==true)
				sum+=instance.values[i];
		return sum;
	}
	
	public int sumWeights(Instance instance) {
		int sum = 0;
		for(int i=0; i<numberOfItems; ++i)
			if(solution[i]==true)
				sum+=instance.weights[i];
		return sum;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean[] getSolution() {
		return solution;
	}
	public void setSolution(boolean[] solution) {
		this.solution = solution;
	}
	public long getRuntime() {
		return runtime;
	}
	public void setRuntime(long runtime) {
		this.runtime = runtime;
	}
	public HashSet<Integer> getPackedItems() {
		return packedItems;
	}
	public void setPackedItems(HashSet<Integer> packedItems) {
		this.packedItems = packedItems;
	}
	
	public void printResult(Instance instance) {	
		System.out.println("Value of optimal knapsack: "+getValue());
		System.out.println("Weight of optimal knapsack: "+getWeight());
		System.out.println("Sum of packed values "+sumValues(instance));	
		System.out.println("Sum of packed weights: "+sumWeights(instance));
		System.out.println("Packed items: "+Arrays.toString(getSolution()));
		System.out.println("Indexes of packed items: "+getPackedItems());
		System.out.println("It took "+getRuntime()/1000000.0+" miliseconds.");
	}
	
}
