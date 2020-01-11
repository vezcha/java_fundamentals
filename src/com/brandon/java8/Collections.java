package com.brandon.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Collections {

	public static void main(String[] args) {
		
		/*
		 * Collection examples
		 * 
		 * operations 
		 * .removeIf() - removes element from list if predicate is true, returns predicate
		 * .replaceAll() - Will apply to all elements
		 * .sort() - sorts the content of a list by passing in a comparator
		 * 		if elements are naturally comparable you can pass in Comparator.naturalOrder()
		 */
		Collection<String> strings = Arrays.asList("one","two","three","four");
		Collection<String> list = new ArrayList<>(strings);
		
		//only works if list is modifiable
		boolean b = list.removeIf(s -> s.length() > 4);
		
		//Iterate through stream and join with ", " separator into single string
		System.out.println(list.stream().collect(Collectors.joining(", ")));

	}

}
