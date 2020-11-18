/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoDB;
import entidade.DetalheVenda;
import entidade.ItemVenda;
import entidade.Venda;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;

/**
 *
 * @author w_olv
 */
public class RelatorioVendaDAO {

    public static List<Venda> getRelatorioVenda() throws SQLException {
        List<Venda> listaVendas = new ArrayList();
        String query;
        PreparedStatement ps = null;
        Date dataFormatada = null;;
        try {
            Connection con = ConexaoDB.getConexao();

            query = "select * from venda";
            ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                double total_venda = rs.getDouble("total_venda");
                String cpf_cliente = rs.getString("cpf_cliente");
                String cpf_func = rs.getString("cpf_func");
                Date data = rs.getDate("data_venda");

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data);

                listaVendas.add(new Venda(id_venda, cpf_cliente, cpf_func, dataString, total_venda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

    public static List<DetalheVenda> getDetalheRelatorioVenda(int id) throws SQLException {
        List<DetalheVenda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();

            String query = "select * from detalhe_venda\n"
                    + "where  detalhe_venda.id_venda=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_produto = rs.getInt("cod_produto");
                String nome = rs.getString("nome");
                int id_venda = rs.getInt("id_venda");
                int qtd_vendida = rs.getInt("qtd_vendida");
                Float subTotal = rs.getFloat("sub_total");
                listaVendas.add(new DetalheVenda(cod_produto, nome, id_venda, qtd_vendida, subTotal, null));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }

    public static List<DetalheVenda> getDetalheRelatorioVendaPorCategoria(String cat) throws SQLException {
        List<DetalheVenda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();

            String query = "select produto.categoria, venda.data_venda,sub_total,detalhe_venda.cod_produto,detalhe_venda.qtd_vendida, detalhe_venda.id_venda, detalhe_venda.nome from detalhe_venda\n"
                    + " inner join venda on detalhe_venda.id_venda = venda.id_venda"
                    + " inner join produto on produto.cod_produto=detalhe_venda.cod_produto where categoria=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_produto = rs.getInt("cod_produto");
                String nome = rs.getString("nome");
                int id_venda = rs.getInt("id_venda");
                int qtd_vendida = rs.getInt("qtd_vendida");
                Float subTotal = rs.getFloat("sub_total");
                String categoria = rs.getString("categoria");

                Date data = rs.getDate("data_venda");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data);

                listaVendas.add(new DetalheVenda(cod_produto, nome, id_venda, qtd_vendida, subTotal, dataString));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }

    public static List<Venda> getDetalheRelatorioVendaPorCliente(String cpf) throws SQLException {
        List<Venda> listaVendas = new ArrayList();
        String query;
        Date dataFormatada = null;;
        try {
            Connection con = ConexaoDB.getConexao();

            query = "select * from venda where cpf_cliente=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                double total_venda = rs.getDouble("total_venda");
                String cpf_cliente = rs.getString("cpf_cliente");
                String cpf_func = rs.getString("cpf_func");
                Date data = rs.getDate("data_venda");

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data);

                listaVendas.add(new Venda(id_venda, cpf_cliente, cpf_func, dataString, total_venda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

    public static List<Venda> getDetalheRelatorioVendaPorFilial(int cod_filial) throws SQLException {
        List<Venda> listaVendas = new ArrayList();
        String query;
        Date dataFormatada = null;;
        try {
            Connection con = ConexaoDB.getConexao();

            query = "select * from venda where cod_filial=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setInt(1, cod_filial);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                double total_venda = rs.getDouble("total_venda");
                String cpf_cliente = rs.getString("cpf_cliente");
                String cpf_func = rs.getString("cpf_func");
                Date data = rs.getDate("data_venda");

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data);

                listaVendas.add(new Venda(id_venda, cpf_cliente, cpf_func, dataString, total_venda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
}
