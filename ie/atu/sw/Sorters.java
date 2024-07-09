package ie.atu.sw;

public class Sorters {

	public String printArray(int[] myArray) {

		// function to return a string version of an arrays content, generally for
		// output ot a user
		String temp = new String();

		for (int i = 0; i < myArray.length; i++) {
			temp += myArray[i];
			if (i < myArray.length - 1) {
				temp += ", ";
			}
		}

		return temp;

	}

	private int splitArray(int[] myArray, int first, int last) {

		// This function is used as part of the quicksort algorithm.
		// it is needed to allow recursion

		// choose the rightmost element as pivot
		int pivot = myArray[last];

		// pointer for greater element
		int i = (first - 1);

		// traverse through all elements
		// compare each element with pivot
		for (int j = first; j < last; j++) {
			if (myArray[j] <= pivot) {

				// if element smaller than pivot is found
				// swap it with the greater element pointed by i
				i++;

				myArray = swap(myArray, i, j);
				// swapping element at i with element at j

			}

		}

		myArray = swap(myArray, i + 1, last);

		// return the position from where partition is done
		return (i + 1);

	}

	private int findMax(int[] myArray) {

		// function to return the element with the highest value from an array
		int max = 0;

		for (int i = 0; i < myArray.length; i++) {
			max = myArray[i] > max ? myArray[i] : max;
		}

		return max;

	}

	private int[] swap(int[] myArray, int indexOne, int indexTwo) {

		// function to swap two elements of an array, given the array and the element
		// indexes
		int holder = myArray[indexOne];
		myArray[indexOne] = myArray[indexTwo];
		myArray[indexTwo] = holder;

		return myArray;

	}

	public int[] bubbleSort(int[] myArray) {

		// Bubblesort implementation
		boolean sorted = false;
		int holder;

		// will return when the array is sorted
		while (!sorted) {
			// if sorted remains true when this while is next checked the array is sorted
			sorted = true;
			// loop through the array
			for (int i = 0; i < myArray.length - 1; i++) {
				// is this element is larger than the next, swap them
				if (myArray[i] > myArray[i + 1]) {
					// oif elements needed to be swapped the array is not sorted.
					sorted = false;
					holder = myArray[i];
					myArray[i] = myArray[i + 1];
					myArray[i + 1] = holder;

				}
			}
		}

		return myArray;

	}

	public int[] selectionSort(int[] myArray) {

		int holder;
		int currentLast = myArray.length;

		// double loop with decrementing checks per iteration, runs faster the longer it
		// runs.
		while (currentLast > 0) {

			for (int i = 0; i < (currentLast - 1); i++) {
				// if elements are not in sorted order, swap them
				if (myArray[i] > myArray[i + 1]) {
					holder = myArray[i];
					myArray[i] = myArray[i + 1];
					myArray[i + 1] = holder;
				}
			}
			currentLast--;
		}

		return myArray;

	}

	public int[] insertionSort(int[] myArray) {

		int holder;

		// loop through entire array
		for (int i = 0; i < myArray.length; i++) {
			int j = i;
			// for each element, loop back through array and put element in it's proper
			// place
			while (j > 0 && myArray[j - 1] > myArray[j]) {
				holder = myArray[j];
				myArray[j] = myArray[j - 1];
				myArray[j - 1] = holder;
				j--;
			}
		}

		return myArray;

	}

	public int[] quickSort(int[] myArray, int first, int last) {

		if (first < last) {

			// find pivot
			int pivot = splitArray(myArray, first, last);

			// start recursion on left section
			quickSort(myArray, first, pivot - 1);

			// start recursion on right section
			quickSort(myArray, pivot + 1, last);
		}

		return myArray;

	}

	public int[] countingSort(int[] myArray) {

		// creation of temporary arrays
		int[] indexArray = new int[findMax(myArray) + 1];
		int[] sortedArray = new int[myArray.length];

		// increment the index of index array, matching the input array
		for (int i = 0; i < myArray.length; i++) {
			indexArray[myArray[i]]++;
		}

		// add all values to their previous index
		for (int i = 1; i < indexArray.length; i++) {
			indexArray[i] = indexArray[i] + indexArray[i - 1];
		}

		// assign the elemnts back into sorted order
		for (int i = 0; i < myArray.length; i++) {
			sortedArray[indexArray[myArray[i]] - 1] = myArray[i];
			indexArray[myArray[i]]--;
		}

		return sortedArray;

	}
}
