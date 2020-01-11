package com.brandon.fundamentals;

import java.io.File;
import java.io.FileFilter;

public class AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileFilter fileFilter = new FileFilter() { //anonymous class defined here
												//the same as implementing FileFilter interface
												// and overriding the accept() method	
			@Override
			public boolean accept(File file) {
				return file.getName().endsWith(".java");
			}
			
		};
		
		File dir = new File("c:/temp");
		File[] javaFiles = dir.listFiles(fileFilter);

	}

}
