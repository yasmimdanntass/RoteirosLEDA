package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor <T extends Comparable<T>>{

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMax;
	private Comparator<T> comparadorMin;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.arrayInterno = (T[]) new Comparable[tamanho];
		this.indice = 0;
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMax = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMin = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[indice] = o;
		indice++;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T elemento = null;
		boolean achou = false;

		for (int i=0;  i < indice ; i++){

			if (achou) {
				arrayInterno[i-1] = arrayInterno[i];
				if (i == indice){
					arrayInterno[i] = null;
				}
			}

			if (o.equals(arrayInterno[i])){
				achou = true;
				elemento = arrayInterno[i];
				indice--;
			}
		}

		return elemento;

	}
	

	// Procura um elemento no vetor
	public T procurar(T o) {
		T elemento = null;

		for (int i=0;  i < indice ; i++){

			if (o.equals(arrayInterno[i])){
				elemento = arrayInterno[i];
			}
		}

		return elemento;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		boolean ehVazio = false;

		if (indice == 0){
			ehVazio = true;
		}

		return ehVazio;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		boolean ehCheio = false;

		if (indice == arrayInterno.length){
			ehCheio = true;
		}

		return ehCheio;
	}

	public T max(){

		T maximo = null;

		if (!isVazio()){
			maximo = arrayInterno[0];

			for (int i=0; i <=indice; i++){
				if (comparadorMax.compare(arrayInterno[i], maximo) > 0){
					maximo = arrayInterno[i];
				}

			}
		}

		return maximo;
		
	}

	public T min(){

		T minimo = null;

		if (!isVazio()){
			minimo = arrayInterno[0];

			for (int i=0; i < indice; i++){
				if (comparadorMin.compare(arrayInterno[i], minimo) < 0){
					minimo = arrayInterno[i];
				}

			}
		}

		return minimo;
		
	}

}
