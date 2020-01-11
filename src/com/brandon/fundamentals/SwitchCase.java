package com.brandon.fundamentals;

public class SwitchCase {

	public static void main(String[] args) {

		int iVal = 10;
		
		//Example of a switch-case use
		switch (iVal % 2) {
			case 0:
				System.out.print(iVal);
				System.out.println(" is even");
				break;
			case 1:
				System.out.print(iVal);
				System.out.println(" is odd");
				break;
			default:
				System.out.println("oops it broke");
				break; // not needed but good practice
		}
		
		//switch case will continue to run all statements below until a break is found.
		//This is true EVEN IF the case does not match below the matching case.

	}

}
