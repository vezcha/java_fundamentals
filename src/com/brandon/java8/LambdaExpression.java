package com.brandon.java8;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {

	public static void main(String[] args) {
		
		/*
		 * Lambda expressions easier and cleaner ways to include function interfaces
		 * without having to create a class to implement or create an anonymous class
		 * using less lines of code
		 * 
		 * Lambdas are considered of type functional interface
		 * 	functional interfaces only have 1 abstract method
		 * 	ex: runnable, comparator, filefilter
		 * 
		 * Lambda is not an clear object, one without an identity
		 * 
		 * Lambda declaring types is optional for functional interfaces
		 */

		/*
		 * Example 1 - Creating a file filter
		 */
		
		//Lambda expressions are easier and cleaner ways to include anonymous classes
		//Object declaration = (method parameters) -> method return statement
		FileFilter filter = (File file) -> file.getName().endsWith(".java");
		
		File dir = new File("c:/temp");
		File[] files = dir.listFiles(filter);
		
		for (File f : files) {
			System.out.println(f);
		}
		
		
		/*
		 * Example 2 -Runnable Lambda
		 */
		
		Runnable runnable = new Runnable() {
			//anonymous class goes here
			@Override
			public void run() {
				for (int i=0; i< 3; i++) {
					System.out.println(
							"Hello world from thread [" +
							Thread.currentThread().getName() +
							"]");
				}
			}
		};
		
		Runnable runnableLambda = () -> { // using {} in lambda for multiple lines
			for (int i=0; i< 3; i++) {
				System.out.println(
						"Hello world from thread [" +
						Thread.currentThread().getName() +
						"]");
			}
		};
		
		//Thread t = new Thread(runnable); using anonymous class
		Thread t = new Thread(runnableLambda);
		
		
		t.start();
		
		try {
			t.join(); //waits for thread to end
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 * Example 3 - create a Comparator with more than 1 parameter
		 * Used to define a comparator then sort through the data
		 */
		
		Comparator<String> comp = new Comparator<String>() { //anonymous class
			
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};
		
		Comparator<String> compLambda = (String s1, String s2) ->
			Integer.compare(s1.length(), s2.length());
		
		List<String> list = Arrays.asList("***","**","****","*");
		//Collections.sort(list, comp); using anonymous class
		Collections.sort(list, compLambda); //using lambda
		
		for(String s : list) {
			System.out.println(s);
		}
		
		
		/*
		 * Lambda shorthand for method reference
		 * the parameters and be left out if they match the static method
		 */ 
		
		//ex 1
		Comparator<Integer> c1 = (i1, i2) -> Integer.compare(i1, i2);
		Comparator<Integer> c2 = Integer::compare;
		
		/*
		 * Lambdas for processing data in collections or any object that implements Iterable
		 * can be used in .forEach() method
		 * both standard lambda and double colon syntax ex:
		 * 
		 * List<Customer> list = ...;
		 * list.forEach(customer -> System.out.println(customer));
		 * list.forEach(System.out::println);
		 */	
		
		
		
		
	}

}
