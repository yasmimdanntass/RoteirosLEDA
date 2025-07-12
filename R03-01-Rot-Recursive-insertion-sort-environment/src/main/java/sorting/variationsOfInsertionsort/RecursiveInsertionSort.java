package sorting.variationsOfInsertionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveInsertionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementacaoo RECURSIVA do insertion sort. Para isso, tente definir o 
	 * caso base do algoritmo e depois o caso recursivo, que reduz o problema 
	 * para uma entrada menor em uma chamada recursiva. Seu algoritmo deve 
	 * ter complexidade quadratica O(n^2).
	 * 
	 * Restrições:
	 *  - voce NAO pode utilizar array auxiliar
	 *  - voce pode utilizar variaveis temporarias
	 *  - voce NAO pode declarar novos atributos na classe
	 *  - para as trocas no array, utilize o metodo Util.swap
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex){
			sort(array, leftIndex, rightIndex -1);
			innerSort(array, rightIndex, leftIndex);
		}
	}

	private void innerSort(T[] array, int index, int leftIndex) {
		if (index > leftIndex && array[index].compareTo(array[index -1]) < 0){
			Util.swap(array, index, index -1);
			innerSort(array, index-1, leftIndex);
		}
	}


}

