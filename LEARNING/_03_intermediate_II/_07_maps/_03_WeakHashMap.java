package _03_intermediate_II._07_maps;

import java.util.WeakHashMap;

public class _03_WeakHashMap {

	public static void main(String[] args) {
		// Creating a WeakHashMap
		WeakHashMap<Object, String> weakMap = new WeakHashMap<>();

		// Creating a key object
		Object key = new Object();

		// Putting key-value pair into the WeakHashMap
		weakMap.put(key, "This is a weak reference value");

		// Display the map before garbage collection
		System.out.println("Before GC: " + weakMap);

		// Removing strong reference to the key
		key = null;

		// Requesting Garbage Collection
		System.gc();

		// Adding a slight delay to allow GC to process
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Display the map after garbage collection
		System.out.println("After GC: " + weakMap);
	}

}
