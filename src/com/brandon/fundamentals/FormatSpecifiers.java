package com.brandon.fundamentals;

public class FormatSpecifiers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int david = 13, dawson = 11, dillon = 4, gordon = 2;
		
		//concatenation example not optimal
		String s1 = "My nephews are " + david + ", "+ dawson + ", "+ dillon + ", and " + gordon + " years old.";
		System.out.println(s1);
		
		//more optimal using String Format
		String s2 = String.format("My nephews are %d, %d, %d, and %d years old.",david,dawson,dillon,gordon);
		System.out.println(s2);
		
		//String format can be used to limit the decimals shown
		double avgDiff = ((david - dawson) + (dawson - dillon) + (dillon - gordon)) / 3.0d;
		System.out.println(avgDiff); //will print 3.666666666666666665 years
		
		String s4 = String.format("The average age difference is %.1f years",avgDiff);
		System.out.println(s4);
		
//format specifiers common syntax
	//	[argument index][flags][width][precision] conversion
	//
	// % - start format specifier conversion
	// d - Decimal
	// o - Octal
	// x or X - Hex
	// f - Decimal for Floating point
	// e or E - Scientific Notation
	// s - String (can passing any object and implements Formatible)
		
//Format Flags
	//	# - include radix
	//	0 - Zero-padding
	//	- - left justify
	//	, - include grouping selector
	//	(space) - leave space for positive numbers (to line up with negative numbers)
	//	+ - always shown sign
	//	( - Enclose negative values in parenthesis
		
//Argument Index
	//not specified - corresponds sequentially to argument
	//$index - index of argument to use
	// < - use same value as previous formatted value
		
		/*
		 * Examples
		 */
		
		// String.format("%#o",32) -> 040
		// String.format("%#x",32) -> 0x20
		// String.format("%#X",32) -> 0X20
		
		// String.format("%4d",5) -> '   5'
		// String.format("%04d,5) -> '0005'
		// String.format("%-4d,5) -> '5   '
		
		//String.format("%,d", 1234567) -> 1,234,567
		//String.format(%,.2f", 1234567.0) -> 1,234,567.00
		
		//String.format("% d",123) -> ' 123'
		//String.format("% d",-456) -> '-456'
		//String.format("%(d",123) -> '123'
		//String.format("%(d",-456) -> '(456)'
		
		//String.format("%3$d %1$d %2$d", 100, 200, 300) -> '300 100 200'
		//String.format("%$2d %<04d %$1d", 100, 200, 300) -> '200 0200 100'
		
		
	}

}
