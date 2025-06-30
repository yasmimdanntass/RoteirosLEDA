package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * subjacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso deste exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * cláusula "throws" dos métodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * Essa versão é genérica e aceita qualquer tipo T que estenda Produto.
 * 
 * @author Adalberto
 */
public class RepositorioProdutoPerecivelArray<T extends Produto> {

	/**
	 * A estrutura (array) onde os produtos são mantidos.
	 */
	private T[] produtos;

	/**
	 * A posição do último elemento inserido no array de produtos. O valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	/**
	 * Construtor que recebe o tamanho do array. Usa cast genérico controlado.
	 */
	@SuppressWarnings("unchecked")
	public RepositorioProdutoPerecivelArray(int size) {
		this.produtos = (T[]) new Produto[size]; // cast seguro por T extends Produto
	}

	/**
	 * Recebe o código do produto e devolve o índice desse produto no array ou
	 * -1 caso ele não se encontre no array.
	 * 
	 * @param codigo
	 * @return índice ou -1
	 */
	private int procurarIndice(int codigo) {
		for (int i = 0; i <= index; i++) {
			if (produtos[i].getCodigo() == codigo) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Recebe o código e diz se tem produto com esse código armazenado
	 * 
	 * @param codigo
	 * @return true se existir, false caso contrário
	 */
	public boolean existe(int codigo) {
		return procurarIndice(codigo) != -1;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(T produto) {
		if (index + 1 >= produtos.length) {
			throw new RuntimeException("REPOSITÓRIO CHEIO!");
		}
		index++;
		produtos[index] = produto;
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto não
	 * esteja no array.
	 */
	public void atualizar(T produto) {
		int pos = procurarIndice(produto.getCodigo());
		if (pos != -1) {
			produtos[pos] = produto;
		} else {
			throw new RuntimeException("PRODUTO NÃO ENCONTRADO!");
		}
	}

	/**
	 * Remove produto com determinado código, se existir, ou então retorna um
	 * erro, caso contrário. A remoção NÃO pode deixar "buracos" no array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		int pos = procurarIndice(codigo);
		if (pos != -1) {
			produtos[pos] = produtos[index];
			produtos[index] = null;
			index--;
		} else {
			throw new RuntimeException("PRODUTO NÃO ENCONTRADO!");
		}
	}

	/**
	 * Retorna um produto com determinado código ou então um erro, caso o
	 * produto não esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public T procurar(int codigo) {
		int pos = procurarIndice(codigo);
		if (pos != -1) {
			return produtos[pos];
		} else {
			throw new RuntimeException("PRODUTO NÃO ENCONTRADO!");
		}
	}
}
