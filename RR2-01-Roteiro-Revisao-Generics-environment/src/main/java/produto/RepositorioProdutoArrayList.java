package produto;

import java.util.ArrayList;

/**
 * Classe que representa um repositório de produtos usando ArrayList como
 * estrutura subjacente. Alguns métodos (atualizar, remover e procurar) ou
 * executam com sucesso ou retornam um erro. Para o caso deste exercício, o erro
 * será representado por uma RuntimeException que não precisa ser declarada na
 * cláusula "throws" dos métodos.
 * 
 * Essa versão é genérica e aceita qualquer tipo T que estenda Produto.
 * Isso garante que os métodos de Produto, como getCodigo(), possam ser usados.
 * 
 * @author Adalberto
 */
public class RepositorioProdutoArrayList<T extends Produto> implements RepositorioProdutos<T> {

    /**
     * A estrutura onde os produtos são mantidos. Voce nao precisa se preocupar
     * por enquanto com o uso de generics em ArrayList.
     */
    private ArrayList<T> produtos;

    /**
     * Construtor que inicializa o ArrayList com uma capacidade inicial.
     * O parâmetro `size` é usado apenas para definir essa capacidade.
     */
    public RepositorioProdutoArrayList(int size) {
        this.produtos = new ArrayList<>(size);
    }

    /**
     * Recebe o código do produto e devolve o índice desse produto no array ou
     * -1 caso ele não se encontre no array. Esse método é útil apenas na
     * implementação com arrays por questões de localização. Outras classes que
     * utilizam outras estruturas internas podem não precisar desse método.
     * 
     * @param codigo
     * @return índice do produto ou -1
     */
    private int procurarIndice(int codigo) {
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getCodigo() == codigo) {
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
    @Override
    public boolean existe(int codigo) {
        return procurarIndice(codigo) != -1;
    }

    /**
     * Insere um novo produto (sem se preocupar com duplicatas)
     * 
     * @param produto a ser inserido
     */
    @Override
    public void inserir(T produto) {
        this.produtos.add(produto);
    }

    /**
     * Atualiza um produto armazenado ou retorna um erro caso o produto não
     * esteja no array. Note que, para localização, o código do produto será
     * utilizado.
     * 
     * @param produto atualizado
     */
    @Override
    public void atualizar(T produto) {
        int indice = procurarIndice(produto.getCodigo());
        if (indice != -1) {
            this.produtos.set(indice, produto);
        } else {
            throw new RuntimeException("O PRODUTO NÃO FOI ENCONTRADO!");
        }
    }

    /**
     * Remove produto com determinado código, se existir, ou então retorna um
     * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
     * array.
     * 
     * @param codigo do produto a ser removido
     */
    @Override
    public void remover(int codigo) {
        int indice = procurarIndice(codigo);
        if (indice != -1) {
            this.produtos.remove(indice);
        } else {
            throw new RuntimeException("O PRODUTO NÃO FOI ENCONTRADO!");
        }
    }

    /**
     * Retorna um produto com determinado código ou então um erro, caso o
     * produto não esteja armazenado.
     * 
     * @param codigo do produto a ser procurado
     * @return o produto correspondente
     */
    @Override
    public T procurar(int codigo) {
        int indice = procurarIndice(codigo);
        if (indice != -1) {
            return this.produtos.get(indice);
        } else {
            throw new RuntimeException("PRODUTO NÃO ENCONTRADO!");
        }
    }
}
