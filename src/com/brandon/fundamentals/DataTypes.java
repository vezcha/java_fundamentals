package com.brandon.fundamentals;

public class DataTypes {
	/*
	 * Block comment example
	 */
	public static void main(String[] args) {
		
		/* Primitive Data Types */
		float floatVal = 1.0f; //32bit or 4 bytes
		double doubleVal = 4.0d; //64bit or 8 bytes
		byte byteVal = 7; // 8bit or 1 byte
		short shortVal = 7; //16bit or 2 bytes
		long longVal = 5; //64bit or 8 bytes
		int intVal = 5; //16bit or 4 bytes
		
		//Widening type conversation happens implicitly
		short result1 = byteVal;
		
		//Narrowing type conversation needs to happen explicitly through a 'cast'
		short result2 = (short)longVal;
		short result3 = (short)(byteVal - longVal);
		
		//Example of type rules
		float result4 = longVal - floatVal;
		long result5 = (long)(shortVal - longVal + floatVal + doubleVal);
		
		System.out.println("Hello World!"); //single line comment
	}

}
