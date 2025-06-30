package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor <T extends Comparable<T>> {

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
		this.indice = -1;
	}

	public void setComparadorMax(Comparator<T> comparadorMax) {
		this.comparadorMax = comparadorMax;
	}

	public void setComparadorMin(Comparator<T> comparadorMin) {
		this.comparadorMin = comparadorMin;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.indice++;
		this.arrayInterno[indice] = o;
	}

	// Remove um objeto do vetor
	public Object remover(T o) {
		T elemento = null;
		for (int i=0; i< arrayInterno.length; i++){
			if (this.arrayInterno[i].equals(o)){
				elemento = this.arrayInterno[i];
				this.arrayInterno = null;
			}
		}
		return elemento;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		T elemento = null;
		for (int i=0; i< arrayInterno.length; i++){
			if (this.arrayInterno[i].equals(o)){
				elemento = this.arrayInterno[i];
			}
		}
		return elemento;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		boolean out = false;
		for (int i=0; i< arrayInterno.length; i++){
			if (this.arrayInterno[i] != null){
				out = true;
			}
		}
		return out;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		boolean out = true;
		for (int i=0; i< indice +1; i++){
			if (this.arrayInterno == null){
				out = false;
			}
		}
		return out;
	}

	
    public T getMaxVetor() {

        T max = arrayInterno[0];
        for (int i = 1; i <= indice; i++) {
            if (comparadorMax.compare(arrayInterno[i], max) > 0) {
                max = arrayInterno[i];
            }
        }
        return max;
    }

	public T getMinVetor() {
		
        T min = arrayInterno[0];
        for (int i = 1; i <= indice; i++) {
            if (comparadorMin.compare(arrayInterno[i], min) > 0) {
                min = arrayInterno[i]; 
            }
        }
        return min;
    }

}

class ComparadorMax implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}

}

class ComparadorMin implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o2.getMedia() - o1.getMedia());
	}

}
