package ie.atu.sw;

public class Main {

	public static void main(String[] args) {

		// set up the test array sizes and MAX values in constants
		final int[] TEST_SIZES = new int[] { 100, 250, 500, 750, 1000, 2500, 3000, 3500, 4500, 6000, 8000, 10000 };
		final int MAX = 10000;

		// for tracking the nanotime for time efficiency
		long startTime;
		long endTime;

		// array to store the results
		float[][] timings = new float[5][TEST_SIZES.length];

		int n = 0;
		int m = 0;

		Sorters mySorter = new Sorters();

		// creation and initialisation of the test and result sort arrays
		for (int i = 0; i < TEST_SIZES.length; i++) {
			int[] testArray = new int[TEST_SIZES[i]];
			int[] testResult = new int[TEST_SIZES[i]];

			System.out.print("Testing Sorts on " + TEST_SIZES[i] + " elements - Sorting");
			for (int j = 0; j < testArray.length; j++) {
				testArray[j] = (int) Math.round(Math.random() * TEST_SIZES[i]);
			}

			// bubble sort test and measure
			startTime = System.nanoTime();
			testResult = mySorter.bubbleSort(testArray.clone());
			endTime = System.nanoTime();
			timings[n++][m] = endTime - startTime;

			// validation of the sorted results
			System.out.print(" - Verifying - [1]");
			for (int k = 0; k < testResult.length - 1; k++) {
				if (testResult[k + 1] < testResult[k]) {
					System.out.println("FAIL! ");
				}
			}

			// selection sort test and measure
			startTime = System.nanoTime();
			testResult = mySorter.selectionSort(testArray.clone());
			endTime = System.nanoTime();
			timings[n++][m] = endTime - startTime;

			// validation of the sorted results
			System.out.print("[2]");
			for (int k = 0; k < testArray.length - 1; k++) {
				if (testResult[k + 1] < testResult[k]) {
					System.out.println("FAIL! ");
				}
			}

			// insertion sort test and measure
			startTime = System.nanoTime();
			testResult = mySorter.insertionSort(testArray.clone());
			endTime = System.nanoTime();
			timings[n++][m] = endTime - startTime;

			// validation of the sorted results
			System.out.print("[3]");
			for (int k = 0; k < testArray.length - 1; k++) {
				if (testResult[k + 1] < testResult[k]) {
					System.out.println("FAIL! ");
				}
			}

			// quick sort test and measure
			startTime = System.nanoTime();
			testResult = mySorter.quickSort(testArray.clone(), 0, testArray.length - 1);
			endTime = System.nanoTime();
			timings[n++][m] = endTime - startTime;

			// validation of the sorted results
			System.out.print("[4]");
			for (int k = 0; k < testArray.length - 1; k++) {
				if (testResult[k + 1] < testResult[k]) {
					System.out.println("FAIL! ");
				}
			}

			// counting sort test and measure
			startTime = System.nanoTime();
			testResult = mySorter.countingSort(testArray.clone());
			endTime = System.nanoTime();
			timings[n][m++] = endTime - startTime;

			// validation of the sorted results
			System.out.print("[5]");
			for (int k = 0; k < testArray.length - 1; k++) {
				if (testResult[k + 1] < testResult[k]) {
					System.out.println("FAIL! ");
				}
			}

			n = 0;

			System.out.println(" - Done.");
		}

		// formatted output of the results
		System.out.println();
		System.out.print("Sample Size >\t\t");
		for (int i = 0; i < TEST_SIZES.length; i++) {
			System.out.print(TEST_SIZES[i] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < timings.length; i++) {
			switch (i) {
			case 0:
				System.out.print("[Bubble]\t\t");
				break;
			case 1:
				System.out.print("[Selection]\t\t");
				break;
			case 2:
				System.out.print("[Insertion]\t\t");
				break;
			case 3:
				System.out.print("[Quick]\t\t\t");
				break;
			case 4:
				System.out.print("[Count]\t\t\t");
			}
			for (int j = 0; j < timings[i].length; j++) {
				// convert to milliseconds and format
				String output = new String(String.format("%.4f", timings[i][j] / 1000000));
				System.out.print(output);
				if (output.length() >= 8) {
					System.out.print("\t");
				} else {
					System.out.print("\t\t");
				}
				if (j == timings[i].length - 1) {
					System.out.println();
				}

			}
		}
		System.out.println();

		System.out.println("Done.");
	}

}
