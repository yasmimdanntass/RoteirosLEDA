package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearchImpl implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer feedback = null;

		if (x != null && array != null && array.length != 0 && array[0] <= x){
			feedback = array[binarySearchFloor(array, x, 0, array.length-1)];
		}
		
		return feedback;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer feedback = null;

		if (x != null && array != null && array.length != 0 && array[array.length-1] >= x){
			feedback = array[binarySearchCeil(array, x, 0, array.length-1)];
		}
		
		return feedback;
	}

	private Integer binarySearchFloor(Integer[] array, Integer x, Integer left, Integer right){
		Integer floorInteger = left;
		Integer middle, a;
											
		if (left < right){                                                    
			middle = (left + right)/2; 
			floorInteger = middle;     
                                                        
			if (array[middle] < x){

				a = binarySearchFloor(array, x, middle + 1, right);                            
				if (array[a] <= x && Math.abs(x - array[a]) < Math.abs(x - array[floorInteger])){
					floorInteger = a;
				}                 

			} else if (array[middle] > x) {
				floorInteger = binarySearchFloor(array, x, left, middle - 1);       
				 
			}
		}

		return floorInteger;
	}

	private Integer binarySearchCeil(Integer[] array, Integer x, Integer left, Integer right){
		Integer floorInteger = left;
		Integer middle, a;
													
		if (left < right){                                                    
			middle = (left + right)/2; 
			floorInteger = middle;           
                                                        
			if (array[middle] < x){
				floorInteger = binarySearchCeil(array, x, middle + 1, right);  

			} else if (array[middle] > x) {
				a = binarySearchCeil(array, x, left, middle -1);                            
				if (array[a] >= x && Math.abs(x - array[a]) < Math.abs(x - array[floorInteger])){ 
					floorInteger = a;
				}
			}
		}
		 return floorInteger;
	}
}
