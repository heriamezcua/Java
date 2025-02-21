package intermediate2._06_collectioninterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class _04_HashSet {
	public static void main(String[] args) {

		// *** CALC THE POSITION OF AN OBJECT IN THE HASH TABLE
		//

		// Define the number of buckets in the hash table
		int numberOfBuckets = 128;

		// Create a simple hash map to simulate a hash table
		Map<Integer, String> hashTable = new HashMap<>();

		// Example object with a specific hash code
		String object = "exampleObject";
		int hashCode = object.hashCode();

		// Calculate the bucket index
		int bucketIndex = Math.abs(hashCode) % numberOfBuckets;

		// Store the object in the hash table
		hashTable.put(bucketIndex, object);

		// Output the results
		System.out.println("Object: " + object);
		System.out.println("Hash Code: " + hashCode);
		System.out.println("Bucket Index: " + bucketIndex);

		// Retrieve the object from the hash table
		String retrievedObject = hashTable.get(bucketIndex);
		System.out.println("Retrieved Object: " + retrievedObject);
	}

	// *** INSERT AN OBJECT INTO A BUCKET
	//
	// We need to manage the collision handling
	class HashTable<K, V> {
		private static class Entry<K, V> {
			K key;
			V value;

			Entry(K key, V value) {
				this.key = key;
				this.value = value;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null || getClass() != obj.getClass())
					return false;
				Entry<?, ?> entry = (Entry<?, ?>) obj;
				return key.equals(entry.key);
			}
		}

		private LinkedList<Entry<K, V>>[] buckets;
		private int size;

		public HashTable(int size) {
			this.size = size;
			buckets = new LinkedList[size];
		}

		private int hash(K key) {
			return Math.abs(key.hashCode() % size);
		}

		public void put(K key, V value) {
			int index = hash(key);

			if (buckets[index] == null) {
				buckets[index] = new LinkedList<>();
			}

			for (Entry<K, V> entry : buckets[index]) {
				if (entry.key.equals(key)) {
					entry.value = value; // Update existing key
					return;
				}
			}

			buckets[index].add(new Entry<>(key, value)); // Insert new entry
		}

		public V get(K key) {
			int index = hash(key);
			if (buckets[index] != null) {
				for (Entry<K, V> entry : buckets[index]) {
					if (entry.key.equals(key)) {
						return entry.value;
					}
				}
			}
			return null;
		}

		public static void main(String[] args) {
			HashTable<String, Integer> hashTable = new HashTable<>(10);
			hashTable.put("apple", 1);
			hashTable.put("banana", 2);
			hashTable.put("grape", 3);
			hashTable.put("apple", 10); // Updating "apple"

			System.out.println("Apple: " + hashTable.get("apple")); // Should print 10
			System.out.println("Banana: " + hashTable.get("banana")); // Should print 2
			System.out.println("Grape: " + hashTable.get("grape")); // Should print 3
			System.out.println("Orange: " + hashTable.get("orange")); // Should print null
		}

		// *** COMPARABLE INTERFACE
		//
		// Hash table keys should implement Comparable
		class HashTable<K extends Comparable<K>, V> {

			// Code ...

		}

		// *** ADJUST INITIAL NUMBER OF BUCKETS
		//
		// Hash table keys should implement Comparable
		public static void main3(String[] args) {
			// Expected number of elements
			int expectedElements = 100;

			// Set initial bucket size (between 75% and 150% of expected elements)
			int initialCapacity = (int) (expectedElements * 1.25); // Example: 125 buckets

			// Creating a HashMap with adjusted initial capacity
			HashMap<Integer, String> map = new HashMap<>(initialCapacity);

			// Adding elements to the HashMap
			for (int i = 0; i < expectedElements; i++) {
				map.put(i, "Value " + i);
			}

			// Print map size to confirm elements were added
			System.out.println("HashMap size: " + map.size());
		}

		// *** HASH MAP REHASING EXAMPLE
		//
		// Rehashing means:
		// Creating a new table with more buckets (usually double).
		// Recalculating the position of each element and moving them to the new table

		public static void main4(String[] args) {
			// Initial capacity set to 4 for demonstration purposes
			Map<Integer, String> map = new HashMap<>(4, 0.75f);

			// Adding elements to trigger rehashing
			System.out.println("Initial size: " + map.size());

			map.put(1, "One");
			map.put(2, "Two");
			map.put(3, "Three");
			map.put(4, "Four"); // At this point, load factor reaches 0.75

			System.out.println("Size after adding 4 elements: " + map.size());

			// Adding one more element should trigger rehashing
			map.put(5, "Five");

			System.out.println("Size after rehashing: " + map.size());

			// Displaying map contents
			for (Map.Entry<Integer, String> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}
		}

	}

	// *** HASH SET TYPE
	//
	//
	static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, age);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;
			Person person = (Person) obj;
			return age == person.age && Objects.equals(name, person.name);
		}

		@Override
		public String toString() {
			return name + " (" + age + ")";
		}
	}

	public class HashSetExample {
		public static void main(String[] args) {
			// Example 1: Reading a file and storing unique words
			Set<String> words = new HashSet<>();
			try (BufferedReader br = new BufferedReader(new FileReader("alice.txt"))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] tokens = line.split("\\W+"); // Split by non-word characters
					words.addAll(Arrays.asList(tokens));
				}
			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
			}
			System.out.println("Unique words: " + words.size());

			// Example 2: Demonstrating the hash issue
			HashSet<Person> people = new HashSet<>();
			Person p = new Person("Alice", 30);
			people.add(p);

			System.out.println("Contains Alice(30) before change: " + people.contains(p));
			p.setAge(31); // Alters state and potentially affects hash
			System.out.println("Contains Alice(31) after change: " + people.contains(p)); // Might print false
		}
	}
}