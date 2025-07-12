package sorting.simpleSorting;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (!(array == null || array.length == 0 || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length -1 )){
			boolean trocou = true;

			while (trocou){

				trocou = false;
				for (int j = leftIndex; j < rightIndex; j++){
					if (array[j].compareTo(array[j+1]) > 0){
						Util.swap(array, j, j + 1);
						trocou = true;
					}
				}
				rightIndex--;
			}
		}
		
	}
}
