package discussion;

import java.util.Random;
import java.util.Scanner;

public class ArrayFill {
	static Random random = new Random();
	
	public static void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	static int[] fillArrayWithRandomNumbers(int arr[],int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(100);            
		}
		return arr;
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]);
			if(i==array.length-1) {
				System.out.println("]");
			}
			else {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of elements for first array: ");
		int size_one = scanner.nextInt();
		int[] array_one = new int[size_one];
		array_one = fillArrayWithRandomNumbers(array_one,size_one);
		bubbleSort(array_one);
		System.out.println("Array 1 after sorting:");
		printArray(array_one);
		
		System.out.print("Enter the number of elements for second array: ");
		int size_two = scanner.nextInt();
		int[] array_two = new int[size_two];
		array_two = fillArrayWithRandomNumbers(array_two,size_two);
		bubbleSort(array_two);
		System.out.println("Array 2 after sorting:");
		printArray(array_two);
		
		//Merging the sorted array
		int i=0,j=0,k=0;
		int result_array[] = new int[array_one.length + array_two.length];
		//till the same number of elements in both the array
		while(i<array_one.length && j<array_two.length) {
			if(array_one[i]<array_two[j])
			result_array[k++] = array_one[i++];
			else
			result_array[k++] = array_two[j++];
		}
		
		//if the first array is having more elements
		while(i<array_one.length) {
			result_array[k++] = array_one[i++];
		}
		
		//if the second array is having more elements
		while(j<array_two.length) {
			result_array[k++] = array_two[j++];
		}
		
		//printing the resultant array
		System.out.println("Final Array");
		printArray(result_array);

	}


}