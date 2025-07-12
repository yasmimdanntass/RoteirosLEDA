package sorting;

/**
 * The interface of all sorting algorithms. It contains only the signature of
 * the sort method, which must be implemented according to the exercice's
 * specific algorithm.
 */
public interface Sorting<T extends Comparable<T>> {

	/**
	 * It sorts the array in increasing order considering all its elements.
	 * 
	 * @param array
	 *            the target of the sorting algorithm
	 */
	public void sort(T[] array, int left, int right);

		if (array != null && left != null && right != null && array.length > 0 && left <= right && left >= 0 && right < array.length){
			int min = left;

			for (int i = left; i < right; i ++){
				min = i;
				for (int j = i; j < right; j ++){
					if (array[j].compareTo(array[min] < 0){
						min = j;
					}
				}
				Util.swap(array, min, i);
			}
		}
}
