package entidade;

public class ItemVenda {
    
    private int idItem;
    private String nomeProduto;
    private String marcaProduto;
    private double valorProduto;
    private int codVenda;
    private int codProduto;
    private int quantidade;
    private double subTotal;

    public ItemVenda() {
    }

    public ItemVenda(int id, int codProduto, String nomeProduto, String marcaProduto, int quantidade, double valorProduto, double subTotal) {
        this.idItem = id;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.valorProduto = valorProduto;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }

    public ItemVenda(int codVenda, int codProduto, int quantidade, Double subTotal) {
        this.codVenda = codVenda;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }

    public int getIdItem() {
        return idItem;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
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
