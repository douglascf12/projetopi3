/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;

/**
 *
 * @author w_olv
 */
public class DetalheVenda {

    int id_venda;
    int cod_produto;
    String data_venda;
    int qtd_vendida;
    String Categoria;
    String cpf_cliente;
    float subTotal;
    String nome;

    public DetalheVenda(int cod_produto, String nome, int id_venda, int qtd_vendida, float subTotal, String data_venda) {
        this.id_venda = id_venda;
        this.cod_produto = cod_produto;
        this.qtd_vendida = qtd_vendida;
        this.subTotal = subTotal;
        this.nome = nome;
        this.data_venda=data_venda;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeProduto) {
        this.nome = nomeProduto;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_venda() {
        return id_venda;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    

    public int getQtd_vendida() {
        return qtd_vendida;
    }

    public void setQtd_vendida(int qtd_vendida) {
        this.qtd_vendida = qtd_vendida;
    }

}
