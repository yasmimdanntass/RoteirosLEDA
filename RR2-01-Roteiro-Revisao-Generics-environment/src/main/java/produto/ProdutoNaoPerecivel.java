package produto;

public class ProdutoNaoPerecivel<T> extends Produto {

    private T formaAcondicionamento;

    public ProdutoNaoPerecivel(int codigo, String nome, double preco,
            String descricao, T formaAcondicionamento) {

        super(codigo, nome, preco, descricao);
        this.formaAcondicionamento = formaAcondicionamento;
    }

    public T getFormaAcondicionamento() {
        return formaAcondicionamento;
    }

    public void setFormaAcondicionamento(T formaAcondicionamento) {
        this.formaAcondicionamento = formaAcondicionamento;
    }
}
