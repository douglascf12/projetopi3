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
    Date data_venda;
    int qtd_vendida;

    public DetalheVenda(int cod_produto, Date data_venda, int qtd_vendida) {
        this.cod_produto = cod_produto;
        this.data_venda = data_venda;
        this.qtd_vendida = qtd_vendida;
    }
    public DetalheVenda(int cod_produto, int qtd_vendida) {
        this.cod_produto = cod_produto;
        this.data_venda = data_venda;
        this.qtd_vendida = qtd_vendida;
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

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public int getQtd_vendida() {
        return qtd_vendida;
    }

    public void setQtd_vendida(int qtd_vendida) {
        this.qtd_vendida = qtd_vendida;
    }

  
}
