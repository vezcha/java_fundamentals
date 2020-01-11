package com.brandon.java8;

public class Comparators {

	public static void main(String[] args) {

		/*
		 * Old way in JDK 7 to create a comparator using anonymous class
		 * will not work if either p1 or p2 is null
		 */
		
//		Comparator<Person> compareLastName =
//				new Comparator<Person>{
//			
//				@Override
//				public int compare(Person p1, Person p2) {
//					return p1.getLastName().compareTo(p2.getLastName());
//				}
//		};
		
		/*
		 * JDK 8 way using .comparing
		 * 
		 * can chain multiple compares using .thenComparing()
		 * can reverse compare using .reverse()
		 * can compare using alphabetical using .naturalOrder()
		 * can prioritize nulls first by using nullsFirst() or last using nullsLast()
		 */
		
		//Comparator<Person> compareLastName = Comparator.comparing(Person::getLastName);
		
		

	}

}
