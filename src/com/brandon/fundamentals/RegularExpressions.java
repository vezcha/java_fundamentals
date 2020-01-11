package com.brandon.fundamentals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Find or exclude groups of characters
		String s1 = "apple, apple, and orange please";
		String s2 = s1.replaceAll("apple", "something");
		
		
		String[] parts = s1.split("\\b");
		
		for(String thePart:parts)
			if(thePart.matches("\\w+"))
				System.out.println(thePart);
		
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(s1);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

		//interactive regex console
		//https://regex101.com
	}

}
