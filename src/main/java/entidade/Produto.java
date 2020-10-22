package entidade;


public class Produto {
    
    private int cod_produto;
    private String descricao;
    private String nome_produto;
    private int qtd_estoque;
    private float preco;

    public Produto(int cod_produto, String descricao, String nome_produto, int qtd_estoque, float preco) {
        this.cod_produto = cod_produto;
        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.qtd_estoque = qtd_estoque;
        this.preco = preco;
    }
    
    public Produto(String descricao, String nome_produto, int qtd_estoque, float preco) {
      
        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.qtd_estoque = qtd_estoque;
        this.preco = preco;
    }
    

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
