package com.brandon.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		/*
		 * A Stream is a typed interface 
		 * 
		 * It's a way to efficiently process large amounts of data (or small)
		 * Data will be process in parallel for CPU
		 * Data operations are piplined to avoid unnecessary intermediary computations
		 * 
		 * A Stream is an object that can define operations
		 * Does not hold any data or change the original data
		 * Processes data in a single pass
		 * 
		 */
		
		// Follow (Map - Filter - Reduce) pattern
		// 3 operation types
		//	forEach() and peek()
		// filter()
		// map() and flatmap()
		
		/*
		 * Example creating a Stream and assigning a stream object
		 */
		List<Integer> ints = Arrays.asList(1,2,3,4,5);
		Stream<Integer> stream = ints.stream();
		
		stream.forEach(System.out::println);
		stream.close();
		
		/*
		 * Example calling a Consumer chain using
		 */
		List<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		
		Consumer<String> c1 = s -> list.add(s); //same as list::add
		Consumer<String> c2 = s -> System.out.println(s); //same as System.out::println
		Consumer<String> c3 = c1.andThen(c2); //example of chaining consumers
		
		list.stream().forEach(c2);
		list.stream().close();
		
		
		/*
		 * Using filter on a Stream
		 */
		List<String> carMakes = Arrays.asList("GMC","Dodge","Ford");
		Stream<String> carStream = carMakes.stream();
		
		Stream<String> filteredCarStream = 
				carStream.filter(car -> car.contains("d"));
		
		filteredCarStream.forEach(System.out::println);
		filteredCarStream.close();
			
		/*
		 * Creating a Stream using the Stream.of() static method
		 * Filtering using a defined predicate
		 */
		
		Stream<String> animalStream = Stream.of("Dog","Cat","Bird","Lizard");
		
		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("Lizard");
		
		Consumer<String> consumer1 = System.out::println;
		
		animalStream
			.filter(p1.or(p2))
			.forEach(consumer1);
		
		animalStream.close();
		
		/*
		 * Intermediary operations vs Final operations in a stream
		 * 
		 * Intermediary operations return a Stream and do not trigger processing
		 * 
		 * Final operations do not return anything and trigger processing of one pass
		 */
		
		Stream<String> languagesStream = Stream.of("Java","C#","Python","PHP","Javascript");
		List<String> langList = new ArrayList<>();
		
		//consumers, predicates
		Predicate<String> p5 = s -> s.contains("Java"); 
		Predicate<String> p6 = s -> s.startsWith("P");
				
		//stream
		languagesStream
			.peek(System.out::println) //intermediary (lazy)
			.filter(p5.or(p6)) //intermediary (lazy)
			.forEach(langList::add); //final (not lazy)
		
		//close stream
		languagesStream.close();
		
		langList.forEach(System.out::println);
		
		
		
		/*
		 * Example using .map() intermediary operation in a Stream
		 * 
		 * .map() takes a function returns a Stream of Streams,
		 *  lazy intermediary stream operation
		 */
		Stream<Integer> luckyNumbers = Stream.of(24,653,1234,6221,276);
		
		//predicates/consumers/functions
		
		//stream operations
		luckyNumbers
			.map(x -> x+1) //lazy
			.forEach(System.out::println);
		//close stream
		luckyNumbers.close();
		
		/*
		 * Example difference of .map() and .flatmap()
		 * 
		 * .flatmap will breakdown a stream of objects into their individual primitive
		 *  values
		 */
		
		List<Integer> numlist1 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> numlist2 = Arrays.asList(2,4,6);
		List<Integer> numlist3 = Arrays.asList(3,5,7);
		
		List<List<Integer>> nestedList = Arrays.asList(numlist1, numlist2, numlist3);
		
		System.out.println(nestedList);
		
		//fucntions/consumers/predicates
		Function<List<?>, Integer> sizeFunction = List::size;
		
		Function<List<Integer>, Stream<Integer>> flatmapperFunction =
				l -> l.stream();
		
		nestedList.stream()
			// .map(sizeFunction) //will return size of lists
			.flatMap(flatmapperFunction)
			.forEach(System.out::println);

		nestedList.stream().close();
		/*
		 * Reduction operations in Streams
		 * use bifunctions that continously reduce the data as they go
		 * example reduces the stream as it iterates through
		 */
		List<Integer> ages = List.of(16,21,26,30);
		Stream<Integer> agesStream = ages.stream();
		
		//Integer sum = agesStream.reduce(0,(age1, age2) -> age1 + age2);
		
		//System.out.print(sum);
		
		agesStream.close();
		/*
		 * Aggregation example 
		 */
		
		Stream<Integer> mathnum1 = Stream.of(1,2,3,4,5);
		
		BinaryOperator<Integer> sumAgg = (i1, i2) -> i1 + i2;
		Integer id = 0;
		
		int result = mathnum1.reduce(id,sumAgg);
		
		System.out.println(result);
		
		/*
		 * Optionals Example and how to use them
		 * .max() -terminal stream operation
		 * .allmatch() - terminal operation that returns boolean based on a predicate
		 */
		
		Stream<Integer> testScores = Stream.of(41,72,92,95,81);
		
		Optional<Integer> maxResult = testScores.max(Comparator.naturalOrder());
		
		if(maxResult.isPresent()) {
			System.out.println(maxResult.get());
		}else{
			try {
				maxResult.orElseThrow(Exception::new);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //lazy construct
		}
		
		testScores.close();
		
		/*
		 * Example using .collect in Streams
		 * .collect and Collectrs are mutable reductions
		 */
		
		
		Stream<Integer> mult5 = Stream.of(5,10,15,20,25);
		
		mult5
			.filter(i -> i % 10 == 0)
			.map(i -> String.valueOf(i+5))
			.collect(
					Collectors.joining(", ") //collects elements to a concatenated String
					//Collectors.toList() //collects elements to a List
					//Collectors.grouppingBy(Person::getAge) //collects elements to a Map
					//Collectors.counting() //downstream collector
			);
	}

}
