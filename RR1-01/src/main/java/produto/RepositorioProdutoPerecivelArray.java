package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoPerecivelArray {

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private ProdutoPerecivel[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutoPerecivelArray(int size) {
		super();
		this.produtos = new ProdutoPerecivel[size];
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

		for (int i = 0; i < this.produtos.length; i++){
			if (this.produtos[i].getCodigo() == codigo){
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

		for (int i = 0; i < this.produtos.length; i++){
			if (this.produtos[i].getCodigo() == codigo){
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(ProdutoPerecivel produto) {
		for (int i =0; i< this.produtos.length; i++){
			if (this.produtos[i] == null){
				this.produtos[i] = produto;
				break;
			}
		}
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(ProdutoPerecivel produto) {
		boolean encontrado = false;

		for (int i = 0; i < this.produtos.length; i++){
			if (this.produtos[i].getCodigo() == produto.getCodigo()){
					this.produtos[i] = produto;
					encontrado = true;
			}
		}

		if (!encontrado) throw new IllegalArgumentException("O PRODUTO NÃO FOI ENCONTRADO");


	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		int posicao = this.produtos.length;

		for (int i = 0; i < this.produtos.length; i++){
			if (this.produtos[i].getCodigo() == codigo){
				this.produtos[i] = null;
				posicao = i + 1;
			}
		}

		for (int i = posicao; i < this.produtos.length; i++){
			this.produtos[i -1] = this.produtos[i];
		}

	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public ProdutoPerecivel procurar(int codigo) {
		ProdutoPerecivel produto = null;

		for (int i = 0; i < this.produtos.length; i++){
			if (this.produtos[i].getCodigo() == codigo){
				produto = this.produtos[i];
			}
		}

		if (produto == null){
			throw new IllegalArgumentException("O PRODUTO NÃO FOI ENCONTRADO")
		}

		return produto;
	}
}
