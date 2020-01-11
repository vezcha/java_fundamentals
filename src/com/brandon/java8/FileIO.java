package com.brandon.java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileIO {

	public static void main(String[] args) {
		
		/*
		 * Reading files in Java8 using try-with-resources and Streams
		 * 
		 * Streams implement AutoCloseable
		 */
		
		//Java 7 : try with resources method
		try(BufferedReader reader =
				new BufferedReader(
				new FileReader(
				new File("people.txt")));){
			
			Stream<String> stream = reader.lines(); //converts BufferedReader into a Stream
			
			stream
				.filter(line -> line.contains("ERROR"))
				.findFirst()
				.ifPresent(System.out::println);
			
		}catch(IOException e) {
			
		}finally{
			
		}
		
		//building a path since Java 7
		Path path = Paths.get("c:","temp","people.txt");
		
		//example of getting Stream from a Path object
		// Stream<String> stream = Files.lines(path)
		
		
		
		/*
		 * Example Java 7 reading directories
		 * 
		 * Files.walk(will also return subdirectories)
		 * to do 2 levels down will be Files.walk(path,2)
		 */
		Path path2 = Paths.get("c:","windows");
		
		try(Stream<Path> dirStream = Files.list(path2)){
			
			dirStream
				.filter(p2 -> p2.toFile().isDirectory())
				.forEach(System.out::println);
			
		}catch(IOException e) {
			
		}
		

	}

}
