package entidade;

import java.util.Date;
import java.util.ArrayList;

public class Venda {

    int id_venda;
    double total_venda;
    String cpf_cliente;
    String cpf_func;
    int cod_filial;
    Date data_venda;
    ArrayList detalheVenda=new ArrayList<DetalheVenda>();

    public Venda(int id_venda, double total_venda, String cpf_cliente, String cpf_func, int cod_filial, Date data_venda) {
        this.id_venda = id_venda;
        this.total_venda = total_venda;
        this.cpf_cliente = cpf_cliente;
        this.cpf_func = cpf_func;
        this.cod_filial = cod_filial;
        this.data_venda = data_venda;
    }

    public Venda(String cpf_cliente, int cod_filial, Date data_venda) {
        this.cpf_cliente = cpf_cliente;
        this.cod_filial = cod_filial;
        this.data_venda = data_venda;
    }

    public int getCod_filial() {
        return cod_filial;
    }

    public void setCod_filial(int cod_filial) {
        this.cod_filial = cod_filial;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
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
