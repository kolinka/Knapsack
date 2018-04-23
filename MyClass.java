package first;

public class MyClass {
	public static void main(String[] args) {
		Instance instance = new Instance();
		instance.drawInstance();	//or instance.enterInstance(); or instance.sampleInstance1(); or instance.sampleInstance2();

		Result result1 = AlgNP1.algNP1(instance);
		System.out.println("Result of the first algorithm from lesson: ");
		result1.printResult(instance);
		
		Result result2 = AlgNP2.algNP2(instance);
		System.out.println("Result of the second algorithm from lesson: ");
		result2.printResult(instance);		
		
		Result result3 = Library.library(instance);
		System.out.println("Result of algorithm from library: ");
		result3.printResult(instance);
	}
}
