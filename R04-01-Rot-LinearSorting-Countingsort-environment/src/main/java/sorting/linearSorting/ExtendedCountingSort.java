package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (!(array == null || array.length == 0 || leftIndex < 0 || rightIndex >= array.length || rightIndex < leftIndex)){

			// get the smallest and the greatest numbers in the array
			int smallest = array[leftIndex];
			int greatest = array[leftIndex]; 

			for (int i = leftIndex; i <= rightIndex; i++){
				if (array[i] < smallest){
					smallest = array[i];
				}
				if (array[i] > greatest){
					greatest = array[i];
				}
			}

			int arrayLength = greatest - smallest + 1;

			// create counter
			int[] counter = new int[arrayLength]; 

			// populate the counter array
			for (int i = leftIndex; i <= rightIndex; i ++){      
				counter[array[i] - smallest] ++;       
			}

			// accumulate the values in the array
			for (int i = 1; i < counter.length; i++){
				counter[i] += counter[i-1];        
			}

			// create a new array
			int[] newArray = new int[array.length]; 

			// populate the new array
			for (int i = newArray.length -1; i > -1; i--){
				if (i >= leftIndex && i <= rightIndex){
					int value = array[i];                  
					int position = counter[value - smallest] -1; 
					newArray[position + leftIndex] = value; 
					counter[value - smallest]--;
				}
			}

			// repopulate the previous array
			for (int i = leftIndex; i <= rightIndex; i++){
				array[i] = newArray[i];
			}
		}
	}

}
