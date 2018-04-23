package first;

import java.util.Scanner;

public class Instance {
	int numberOfItems;
	double[] values = new double[numberOfItems];
	int[] weights;
	int maxWeight;
	
	public Instance(int n) {
		numberOfItems = n;
	}
	
	public Instance() {
		numberOfItems = 20;
		
		double[] values = new double[numberOfItems];
		setValues(values);
		
		int[] weights = new int[numberOfItems];
		for(int i=0; i<numberOfItems; ++i)
			weights[i] = Integer.MAX_VALUE/20;
		setWeights(weights);
		
		maxWeight = 0;
	}
	
	public void sampleInstance1() {
	    setNumberOfItems(4);
		double[] v = {100, 20, 60, 40};
		setValues(v);
		int[] w = {3, 2, 4, 1};
		setWeights(w);
		setMaxWeight(5);
	}
	
	public void sampleInstance2() {
		setNumberOfItems(20);
		double[] v = {84.32, 43, 21.32, 234.10, 414, 34, 293.0193, 293, 21, 123, 192, 3, 1.039, 123, 39.23, 42, 194.23, 59.1, 93, 293};
		setValues(v);
		int[] w = {49, 43, 10, 4, 92, 49, 10, 29, 19, 23, 3, 120, 30, 394, 31, 44, 12, 24, 36, 75}; 
		setWeights(w);
		setMaxWeight(400);
	}
	
	public void drawGUIInstance(int numberOfItems) {
		int i;
		setNumberOfItems(numberOfItems);
		
		double[] values = new double[numberOfItems];
	    for (i = 0; i < values.length; i++) {
	    	values[i] = Math.random()*10000;
		    values[i] = Math.round(values[i]);
		    values[i]/=100;
	    }	    
		int[] weights = new int[numberOfItems];
	    for (i = 0; i < weights.length; i++) {
	      weights[i] = (int) Math.round(Math.random()*100);
	    }		    
		setValues(values);
		setWeights(weights);
		
		int max = (int) Math.round(Math.random()*sumWeights());
		setMaxWeight(max);
	}
	
	public void drawInstance() {
		System.out.println("How many items do you want to pack? ");
		Scanner scanner = new Scanner(System.in);
		int i, numberOfItems = scanner.nextInt();
		setNumberOfItems(numberOfItems);
		
		double[] values = new double[numberOfItems];
	    for (i = 0; i < values.length; i++) {
	      values[i] = Math.random()*10000;
	      values[i] = Math.round(values[i]);
	      values[i]/=100;
	    }		
		int[] weights = new int[numberOfItems];
	    for (i = 0; i < weights.length; i++) {
	      weights[i] = (int) Math.round(Math.random()*100);
	    }
		    
		setValues(values);
		setWeights(weights);
		    
		//check
		System.out.println("Random prices: ");
		for(i=0; i<numberOfItems; ++i)
		    System.out.print(getValues()[i]+" ");
		
		System.out.println("\nand random weigths: ");
		for(i=0; i<numberOfItems; ++i)
		    System.out.print(getWeights()[i]+" ");

		System.out.println("\nSum of all the values is: "+sumValues());
		System.out.println("Give the maximal weight of knapsack: ");
		System.out.println("For nontrivial solution choose less than "+sumWeights());
		
		int max = scanner.nextInt();
		setMaxWeight(max);
		
		scanner.close();
	}
	
	public void enterInstance() {
		int i;
		
		System.out.println("How many items do you want to pack? ");
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		setNumberOfItems(n);
		
		double[] values = new double[n];
		int[] weights = new int[n];
		System.out.println("Give values of "+n+ " items: ");
		for(i=0; i<n; ++i)
		    values[i]=scanner.nextDouble();		//commas, not dots!
		setValues(values);
		
		System.out.println("Give weights of "+n+ " items: ");
		for(i=0; i<n; ++i)
		    weights[i]=scanner.nextInt();
		setWeights(weights);
		    
		//check
		System.out.println("You gave values: ");
		for(i=0; i<n; ++i)
		    System.out.print(values[i]+" ");
		
		System.out.println("\nand weigths: ");
		for(i=0; i<n; ++i)
		    System.out.print(weights[i]+" ");
		    
		int sum=0;
		for(i=0; i<n; ++i)
		    sum+=weights[i];
		
		System.out.println("\nGive the maximal weight of knapsack: ");
		System.out.println("For nontrivial solution choose less than "+sum);
		
		int max = scanner.nextInt();
		setMaxWeight(max);
		scanner.close();
	}

	public double sumValues() {
		double sum = 0;
		for(double value: values)
			sum+=value;
		return sum;
	}
	
	public int sumWeights() {
		int sum = 0;
		for(double weight: weights)
			sum+=weight;
		return sum;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int n) {
		numberOfItems = n;
	}
	public void setNumberOfItems() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many items do you want to pack? ");
		numberOfItems = scanner.nextInt();
		scanner.close();	
	}
	public double[] getValues() {
		return values;
	}
	public void setValues(double[] values) {
		this.values = values;
	}
	public void setValues() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give values of "+numberOfItems+ " items: ");
		int i=0;
		for(i=0; i<numberOfItems; ++i)
		    values[i]=scanner.nextDouble();
		scanner.close();
		//check
		System.out.println("You gave values: ");
		for(i=0; i<numberOfItems; ++i)
		    System.out.print(values[i]+" ");
	}
	
	public int[] getWeights() {
		return weights;
	}
	public void setWeights(int[] weights) {
		this.weights = weights;
	}
	public void setWeights() {
		System.out.println("Confirm the number of items: ");
		Scanner scannerw = new Scanner(System.in);
		int n = scannerw.nextInt();
		System.out.println("Give weights of "+n/*umberOfItems*/+ " items: ");
		int i;
		for(i=0; i<n/*umberOfItems*/; ++i)
		    weights[i]=scannerw.nextInt();
		scannerw.close();
		//check
		System.out.println("You gave weights: ");
		for(i=0; i<n/*umberOfItems*/; ++i)
		    System.out.print(weights[i]+" ");
	}
	
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public void setMaxWeight() {
		Scanner scanner = new Scanner(System.in);
		int sumOfWeights = 0;
		for(int weight: weights)
		    sumOfWeights+=weight;
		System.out.println("Give the maximal weight of knapsack: ");
		System.out.println("For nontrivial solution choose less than "+sumOfWeights);
		maxWeight = scanner.nextInt();
		scanner.close();
	}
	
}
