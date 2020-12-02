package entidade;

public class Produto {

    private int cod_produto;
    private String descricao;
    private String nome_produto;
    private int qtd_estoque;
    private float preco;
    private String categoria;
    private int qtd_vendida;
    private float subTotal;
    private int cod_filial;

    public Produto(int cod_produto, String descricao, String nome_produto, int qtd_estoque, float preco, String categoria) {
        this.cod_produto = cod_produto;
        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.qtd_estoque = qtd_estoque;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto(String descricao, String nome_produto, int qtd_estoque, float preco, String categoria) {

        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.qtd_estoque = qtd_estoque;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto(int cod_produto, String descricao, String nome_produto, int qtd_estoque, float preco, String categoria, int codFilial) {
        this.cod_produto = cod_produto;
        this.descricao = descricao;
        this.nome_produto = nome_produto;
        this.qtd_estoque = qtd_estoque;
        this.preco = preco;
        this.categoria = categoria;
        this.cod_filial = codFilial;
    }

    public int getCod_filial() {
        return cod_filial;
    }

    public void setCod_filial(int cod_filial) {
        this.cod_filial = cod_filial;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public int getQtd_vendida() {
        return qtd_vendida;
    }

    public void setQtd_vendida(int qtd_vendida) {
        this.qtd_vendida = qtd_vendida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public enum Categoria {

        CAMA("Cama"), MESA("Mesa"), BANHO("Banho");

        String categoria;

        private Categoria(String categoria) {
            this.categoria = categoria;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public static Categoria getCAMA() {
            return CAMA;
        }

        public static Categoria getMESA() {
            return MESA;
        }

        public static Categoria getBANHO() {
            return BANHO;
        }

    }

}
