package produto;

import java.util.ArrayList;

/**
 * Classe que representa um repositório de produtos usando ArrayList como
 * estrutura sobrejacente. Alguns métodos (atualizar, remover e procurar) ou
 * executam com sucesso ou retornam um erro. Para o caso desde exercício, o erro
 * será representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 *
 * @author Adalberto
 */
public class RepositorioProdutoArrayList {

	/**
	 * A estrutura onde os produtos sao mantidos. Voce nao precisa se preocupar
	 * por enquanto com o uso de generics em ArrayList.
	 */
	private ArrayList<Produto> produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoArrayList(int size) {
		super();
		this.produtos = new ArrayList<Produto>();
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int indice = -1;

		for (int i = 0; i < this.produtos.size(); i++){ 
			if (this.produtos.get(i).getCodigo() == codigo){
				indice = i;
			}
		}

		return indice;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		boolean existe = false;

		for (int i = 0; i < this.produtos.size(); i++){
			if (this.produtos.get(i).getCodigo() == codigo){
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(Produto produto) {
		this.produtos.add(produto);
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(Produto produto) {
		boolean alterado = false;

		for (int i = 0; i < this.produtos.size(); i++){
			if (this.produtos.get(i).getCodigo() == produto.getCodigo()){
				this.produtos.set(i, produto);
				alterado = true;
			}
		}

		if (!alterado){
			throw new RuntimeException("O PRODUTO NÃO FOI ENCONTRADO!");
		}
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		boolean removido = false;

		for (int i = 0; i < this.produtos.size(); i++){
			if (this.produtos.get(i).getCodigo() == codigo){
				this.produtos.remove(i);
				removido = true;
			}
		}

		if (!removido){
			throw new RuntimeException("O PRODUTO NÃO FOI ENCONTRADO!");
		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto procurar(int codigo) {
		Produto produto = null;

		for (int i = 0; i < this.produtos.size(); i++){
			if (this.produtos.get(i).getCodigo() == codigo){
				produto = this.produtos.get(i);
			}
		}

		if (produto == null){
			throw new RuntimeException("PRODUTO NÃO ENCONTRADO!");
		}

		return produto;
	}
}
