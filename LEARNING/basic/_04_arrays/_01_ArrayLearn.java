package basic._04_arrays;

import java.util.Arrays;

public class _01_ArrayLearn {
	public static void main(String[] args) {

		// INSTANTIATION
		int[] my_array = new int[3];
		int[] array = { 2, 3, 4 };

		// ACCESS AND MODIFICATION
		array[0] = 2;
		array[2] = 3;
		array[array.length - 1] = 33;

		// FOREACH LOOP
		for (int i : array) {
			// instructions
		}

		// HACK to print all elements of an array
		System.out.println(Arrays.toString(array));

		// Copy of arrays
		int[] copyBad = array; // this is wrong bc you are copying the reference

		// we need to do this
		int[] copyGood = new int[array.length];

		for (int index = 0; index < array.length; index++) {
			copyGood[index] = array[index];
		}

		// HACK to copy an array easy
		int[] copyEasy = Arrays.copyOf(array, array.length);

		// SORT an array
		Arrays.sort(array); // this use quicksort algorithm

		// Like sort, there are more Array algorithms
	}
}
