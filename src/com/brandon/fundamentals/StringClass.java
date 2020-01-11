package com.brandon.fundamentals;

public class StringClass {

	public static void main(String[] args) {
		
		String s1 = "I Love";
		s1 += " Java";
		
		String s2 = "I";
		s2 += " Love Java";
		
		//returns false because the object references are different
		if (s1 == s2) {System.out.println("true");}else{System.out.println("false");}
		
		//returns true because .equals does expensive char by char comparison
		if (s1.equals(s2)){System.out.println("true");}else{System.out.println("false");}
		
		/*
		 * .intern() returns a canonical representation of a string which always
		 *  be the same for each String with the same value
		 */
		String s3 = s1.intern(); 
		String s4 = s2.intern(); //s3 and s4 now reference the exact same object string
		
		//returns true and does inexpensive '==' comparison
		if (s3 == s4){System.out.println("true");}else{System.out.println("false");}
		
		//summary: use .equals when comparing a few strings and inter() when comparing many

	}

}
