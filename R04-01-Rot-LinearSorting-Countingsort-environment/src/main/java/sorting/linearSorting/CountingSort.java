package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (!(array == null || array.length == 0 || leftIndex < 0 || rightIndex >= array.length || rightIndex < leftIndex)){

			// get the greatest number in the array
			int greatest = array[leftIndex];

			for (int i = leftIndex; i <= rightIndex; i++){
				if (array[i] > greatest){
					greatest = array[i];
				}
			}

			// set up the counter
			int[] counter = new int[greatest + 1];

			// populate the counter
			for (int i = leftIndex; i <= rightIndex; i ++){
				counter[array[i]] ++;
			}

			// accumule the values
			for (int i = 1; i < counter.length; i ++){
				counter[i] += counter[i-1];
			}

			// create the new array
			int[] newArray = new int[rightIndex - leftIndex + 1];

			// populate the new array
			for (int i = rightIndex; i >= leftIndex; i--){
					int value = array[i];
					int position = counter[value] -1;
					newArray[position] = value;
					counter[value]--;
				}

			// repopulate the previous array
			for (int i = leftIndex; i <= rightIndex; i++){
				array[i] = newArray[i - leftIndex];
			}
		}
	}
}