package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (!(array == null || array.length == 0 || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length -1 )){
			
			for (int i = leftIndex + 1; i <= rightIndex; i++){
				int counter = i;
				while (counter > leftIndex){
					if (array[counter].compareTo(array[counter -1]) < 0){
						Util.swap(array, counter -1, counter);
					}
					counter--;
				}
			}

		}
	}
}
