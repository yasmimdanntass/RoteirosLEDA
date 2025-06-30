package produto;

public interface RepositorioProdutos<T> {

	public abstract boolean existe(int codigo);

	public abstract void inserir(T produto);

	public abstract void atualizar(T produto);

	public abstract void remover(int codigo);

	public abstract T procurar(int codigo);

}