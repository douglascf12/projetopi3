/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author w_olv
 */
public class Venda {

    int id_venda;
    double total_venda;
    String cpf_cliente;
    String cpf_func;
    ArrayList detalheVenda=new ArrayList<DetalheVenda>();

    public Venda(int id_venda, double total_venda, String cpf_cliente, String cpf_func) {
        this.id_venda = id_venda;
        this.total_venda = total_venda;
        this.cpf_cliente = cpf_cliente;
        this.cpf_func = cpf_func;        
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_venda() {
        return id_venda;
    }

    public double getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getCpf_func() {
        return cpf_func;
    }

    public void setCpf_func(String cpf_func) {
        this.cpf_func = cpf_func;
    }

}
