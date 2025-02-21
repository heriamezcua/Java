package intermediate2._05_collectionsintro;

import java.util.Iterator;
import java.util.function.Consumer;

public class _01_Intro {

	public static void main(String[] args) {

		// In modern data structure libraries, interfaces and implementations are
		// separated, watch class and interface below

	}

	// 1. Example of implementation of the Queue Collection below
	public class CircularArrayQueue<E> implements Queue<E> {
		private int head;
		private int tail;

		CircularArrayQueue(int capacity) {
		}

		public void add(E element) {
		}

		public E remove() {
		}

		public int size() {
			// code
		}

		private E[] elements;
	}

	// 2.
	public interface Queue<E> // a simplified form of the interface in the standard library
	{
		void add(E element);

		E remove();

		int size();
	}

}
