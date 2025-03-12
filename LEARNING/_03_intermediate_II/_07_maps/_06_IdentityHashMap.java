package _03_intermediate_II._07_maps;

import java.util.IdentityHashMap;

public class _06_IdentityHashMap {
	public static void main(String[] args) {
		// Creating an IdentityHashMap
		IdentityHashMap<MyKey, String> map = new IdentityHashMap<>();

		// Creating keys with the same content but different instances
		MyKey key1 = new MyKey("hello");
		MyKey key2 = new MyKey("hello");

		// Adding values to the map
		map.put(key1, "Value 1");
		map.put(key2, "Value 2");

		// Displaying the map size
		System.out.println("Map size: " + map.size()); // Should print 2 because key1 and key2 are different instances
	}

	class MyKey {
		String value;

		public MyKey(String value) {
			this.value = value;
		}
	}
}
