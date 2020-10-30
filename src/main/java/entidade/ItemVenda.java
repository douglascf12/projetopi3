package entidade;

public class ItemVenda {
    
    private int idItem;
    private String nome;
    private double preco;
    private int quantidade;
    private int codVenda;
    private int codProduto;
    private double subTotal;
    private String categoria;
    private String cpf_cliente;

    public ItemVenda() {
    }

    public ItemVenda(int idItem, String nome, double preco, int quantidade, int codVenda, int codProduto, double subTotal) {
        this.idItem = idItem;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codVenda = codVenda;
        this.codProduto = codProduto;
        this.subTotal = subTotal;
    }

    public ItemVenda(int codVenda, int codProduto, int quantidade, Double subTotal) {
        this.codVenda = codVenda;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }

    public ItemVenda(int idItem, int codProduto, String nome, int quantidade, double preco, double subTotal) {
        this.idItem = idItem;
        this.codProduto = codProduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.subTotal = subTotal;
    }

    public ItemVenda(int codVenda, int codProduto, int quantidade, Double subTotal, String categoria) {
        this.codVenda = codVenda;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
        this.categoria = categoria;   
    }
    public ItemVenda( int codProduto, int quantidade,  String categoria, String cpf_cliente) {

        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.cpf_cliente = cpf_cliente;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    
    public int getIdItem() {
        return idItem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
