package com.brandon.fundamentals;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Collections are more powerful than arrays
		 * - iterable
		 * - tend to dynamically size
		 * - can provide optimizations for sorting
		 * 
		 * most collections implement the Collection interface
		 * size -
		 * clear -
		 * isEmpty -
		 * add -
		 * addAll - 
		 */
		
		/*
		 * Common Equality-based Methods
		 * 
		 * all based on the .equals method
		 * ==============================
		 * contains - returns true if contains element
		 * containsAll
		 * remove
		 * removeAll
		 * retainAll - remove all elements not contained in another collection
		 */
		
		/*
		 * Collection methods that leverage lambdas
		 * forEach
		 * removeIF
		 */
		
		/*
		 * Collections converting to and from array
		 * toArray() can pass type (Object) as parameter
		 */
		
		//ex Object[] objArray = list.toArray()
		//ex MyClass[] a1 = list.toArray(new MyClass[0])
		
		//Collection<MyClass> list = Arrays.asList(myArray)
		
		/*
		 * Common Collection types
		 * 
		 *Interfaces
		 *=================
		 *Collection
		 *List
		 *Queue
		 *Set
		 *SortedSet
		 *
		 *Collection Classes
		 *==================
		 *ArrayList
		 *LinkedList inefficent for random access
		 *HashSet - Set implemented as a hash table efficient general purpose usage at any size
		 *TreeSet - SortedSet implemented as a balanced binary tree less efficient to modify and search than a hashset
		 *
		 */
		
		/*
		 * Sorting
		 * 
		 * Comparable interface - implemented by the type to be sorted, should be consistant with equals
		 * Comparator interface - Specifies alternative sort behavior for another type
		 * 
		 * 
		 */
		
		/*
		 * Maps
		 * ==============
		 * Map - basic map
		 * SortedMap - map where keys are sorted
		 * 
		 * 
		 * Classes that implement Map
		 * ====================
		 * Hashmap - efficent implemention of Map implementation
		 * TreeMap - SortedMap implemented as self-balancing tree
		 * 
		 * Map methods
		 * ========================
		 * put - add key and value
		 * putIfAbsent - add key and value if key not contained or value null
		 * get - return value for key
		 * getOrDefault - return value for key, if not found return default value
		 * values - return a Collection of the contained values
		 * keySet - Return a Set of the contained keys
		 * replaceAll - perform an expression for modifying each key
		 * 
		 */
		
		Map<String, String> map = new HashMap<>();
		map.put("2222","ghi");
		map.put("3333","abc");
		map.put("1111","def");
		
		String s1 = map.get("3333"); //abc
		String s2 = map.get("9999"); //null
		String s3 = map.getOrDefault("9999","xyz"); //xyz
		
		map.forEach((k, v) -> System.out.println(k + " | " + v));
		
		map.replaceAll((k, v) -> v.toUpperCase());
		map.forEach((k, v) -> System.out.println(k + " | " + v));
		System.out.println();
		/*
		 * SortedMap Methods
		 * firstKey - returns first key
		 * lastKey - returns last key
		 * headMap - returns a map for all keys that are less than specified key
		 * tailMap - return a map for all keys that are greater OR EQUAL than specified key
		 * subMap - returns a map that are greater than the start key and less than the end key
		 */
		
		SortedMap<String, String> smap = new TreeMap<>();
		
		smap.put("2222", "ghi");
		smap.put("3333", "abc");
		smap.put("1111", "def");
		smap.put("6666", "xyz");
		smap.put("4444", "mno");
		smap.put("5555", "pqr");
		
		smap.forEach((k, v) -> System.out.println(k + " | "+ v));
		
		SortedMap<String, String> hMap = smap.headMap("3333"); // map that contains 1111 and 2222
		SortedMap<String, String> tMap = smap.tailMap("3333"); // will include 3333 4444 5555 6666
		

	}

}
