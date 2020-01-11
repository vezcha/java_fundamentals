package com.brandon.fundamentals;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

public class WritingFormattedContent {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedWriter writer = Files.newBufferedWriter(Paths.get("myFile.txt"));
		
		//try with resources
		try (Formatter f = new Formatter(writer)){
			f.format("my numbers are %d, %d, %d", 1, 2, 3);
		}

	}

}
