package com.brandon.java10;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

public class LocalVariableTypeInference {

	public static void main(String[] args) {
		
		/*
		 * Java 10 new feature Local-variable Type inference
		 */
		//no longer have to declare type when it can be assumed from the assignment
		//allows variable names to provide a better meaning opposed to its type
		//var is a reserved type NOT a keyword to maintain backwards compatibility
		
		var name = "Sander"; //compiler using type inference to understand String
		
		//Example of cluttered type code
		URL url = new URL("http://javamodularity.com");
		URLConnection urlConnection = url.openConnection();
		BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

		//Example using local-variable type inference var syntax
		var bookurl = new URL("http://javamodularity.com");
		var connection = bookurl.openConnection();
		var bookStream = new BufferedInputStream(connection.getInputStream());
		
		//shouldn't use var for declaring generic types
		//ex : var myList = new ArrayList<>()
		// should be List<String> list = new ArrayList<>()
		
	}

}
