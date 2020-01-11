package com.brandon.fundamentals;

public class VariableParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printNumbers(1);
		printNumbers(1,2);
		printNumbers(1,2,3);

	}
	//define method with variable # of parameters
	//variable parameter MUST be last parameter
	//can use for loop to iterate through variable list
	//java will create an array and allows the parameter to be treated as one
	private static void printNumbers(int... numbers) {
		
		System.out.println();	
		
		for(int n : numbers) {
			System.out.print(n + " ");
		}

	}

}
