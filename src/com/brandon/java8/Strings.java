package com.brandon.java8;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Strings {

	public static void main(String[] args) {
		/*
		 * Example creating an IntStream representing characters in a String
		 */
		String s = "Hello World";
		
		IntStream stream = s.chars();
		
		stream
			.mapToObj(letter -> (char)letter)
			.map(Character::toUpperCase)
			.forEach(System.out::print);
		
		/*
		 * When building or concatening Strings try not to use the '+' operator
		 * 
		 * Use the StringBuffer obj and use .append()
		 * 
		 * Stringbuffer is synchronized so it is not ideal
		 * 
		 * StringBuilder is async and much quicker to execute (+ concate will default to this)
		 * 
		 * StringJoiner is best way in JDK 8 to join strings
		 * 
		 */
		
		//Bad
		System.out.println("Hello"+ " "+ "World");
		
		//Okay (not ideal because StringBuffer is synchronized)
		StringBuffer sb1 = new StringBuffer();
		
		sb1.append("Hello");
		sb1.append(" ");
		sb1.append("World");
		
		System.out.println(sb1.toString());
		
		//Good (better than StringBuffer but not)
		StringBuilder sbuild1 = new StringBuilder();
		sbuild1.append("Hello");
		sbuild1.append(" ");
		sbuild1.append("World");
		
		System.out.println(sbuild1);
		
		//Best (simple way with built in separator) also optional to include prefix and postfix
		StringJoiner sj = new StringJoiner(" "); //add separator to constructor
		sj.add("Hello").add("World");
		
		System.out.println(sj.toString());
		
		//StringJoiner can also be used directly from String class
		//can pass in values directly or any Iterable
		String str1 = String.join(", ","one","two","three");
		System.out.println(str1);
	}

}
