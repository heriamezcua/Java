package intermediate1._05_arraylists;

import java.util.ArrayList;

public class ArrayLists {
	public static void main(String[] args) {

		// ArrayList class

		// from
		// import java.util.ArrayList;

		// Declaration
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();

		ArrayList<Integer> myArrayList2 = new ArrayList<>();

		// Common methods
		myArrayList.add(2);
		myArrayList.clear();
		myArrayList.size();
		myArrayList.trimToSize();

		// Ensure Capacity
		// via declaring
		ArrayList<Integer> myArrayListEnsure = new ArrayList<Integer>(100);

		// using the method
		myArrayList.ensureCapacity(50);

		// ArrayList. Access and Modification
		// declaration
		ArrayList<Integer> miArrayList = new ArrayList<Integer>();

		// add element
		miArrayList.add(12);

		// replace element
		miArrayList.set(0, 33);

		// obtaining
		miArrayList.get(0);

		// transform to an array
		Integer[] toAnArray = new Integer[miArrayList.size()];
		miArrayList.toArray(toAnArray);

		// add an element in the middle
		int index = miArrayList.size() / 2;
		miArrayList.add(index, 44);

	}
}