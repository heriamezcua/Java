package basic._06_heapandstack;

import java.util.ArrayList;
import java.util.List;

public class _01_HeapAndStack {
	public static void main(String[] args) {
		causeOutOfMemoryError();
	}

	// this function provoke an stack overflow error
	public static int provokeStackOverflow(int n) {
		return provokeStackOverflow(n);
	}

	// this function provoke an out of memory error
	public static void causeOutOfMemoryError() {
		List<int[]> list = new ArrayList<>();

		try {
			while (true) {
				list.add(new int[1000000]);
			}
		} catch (OutOfMemoryError e) {
			System.out.println("¡OutOfMemoryError!");
		}
	}
}
