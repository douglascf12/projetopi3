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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

                listaVendas.add(new Venda(id_venda, total_venda, cpf_cliente, cpf_func));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

    public static List<ItemVenda> getDetalheRelatorioVenda(int id) throws SQLException {
        List<ItemVenda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();

            String query = "select item_venda.codigoProduto, item_venda.quantidade,item_venda.codigoVenda, item_venda.subTotal, categoria from item_venda\n"
                    + "inner join produto on produto.cod_produto=item_venda.codigoProduto where  item_venda.codigoVenda=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int qtd_vendida = rs.getInt("quantidade");
                int cod_produto = rs.getInt("codigoProduto");
                int codVenda = rs.getInt("codigoVenda");
                Double subTotal = rs.getDouble("subTotal");
                listaVendas.add(new ItemVenda( codVenda,cod_produto, qtd_vendida,  subTotal));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }
    public static List<ItemVenda> getDetalheRelatorioVendaPorCategoria(String cat) throws SQLException {
        List<ItemVenda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();

            String query = "select item_venda.codigoProduto, item_venda.quantidade,item_venda.codigoVenda, item_venda.subTotal, categoria from item_venda\n"
                    + "inner join produto on produto.cod_produto=item_venda.codigoProduto where  categoria=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int qtd_vendida = rs.getInt("quantidade");
                int cod_produto = rs.getInt("codigoProduto");
                int codVenda = rs.getInt("codigoVenda");
                Double subTotal = rs.getDouble("subTotal");
                String categoria = rs.getString("categoria");
                listaVendas.add(new ItemVenda( codVenda,cod_produto, qtd_vendida,  subTotal, categoria));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }
    public static List<ItemVenda> getDetalheRelatorioVendaPorCliente(String cpf) throws SQLException {
        List<ItemVenda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();

            String query = "select venda.cpf_cliente, item_venda.codigoProduto,  item_venda.quantidade, categoria from item_venda \n"
                    + "inner join produto on produto.cod_produto=item_venda.codigoProduto \n" +
            "inner join venda on item_venda.codigoVenda = venda.id_venda  where venda.cpf_cliente=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cpf_cliente = rs.getString("cpf_cliente");
                int cod_produto = rs.getInt("cod_produto");
                int qtd_vendida = rs.getInt("quantidade");
                String categoria = rs.getString("categoria");
               
                listaVendas.add(new ItemVenda(cod_produto, qtd_vendida,  categoria, cpf_cliente));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }

    

   
    public static List<DetalheVenda> getDetalheRelatorioVendaPorFilial(int cod_filial) throws SQLException {
        List<DetalheVenda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();

            String query = "select venda.cod_filial, detalhes_venda.cod_produto, detalhes_venda.data_venda, detalhes_venda.qtd_vendida,categoria from detalhes_venda \n"
                    + "inner join produto on produto.cod_produto=detalhes_venda.cod_produto \n" +
            "inner join venda on detalhes_venda.id_venda=venda.id_venda  where venda.cod_filial=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cod_filial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codigo_filial = rs.getInt("cod_filial");
                Date data_venda = rs.getDate("data_venda");
                int cod_produto = rs.getInt("cod_produto");
                int qtd_vendida = rs.getInt("qtd_vendida");
                String categoria = rs.getString("categoria");
                    
                listaVendas.add(new DetalheVenda(cod_produto, data_venda, qtd_vendida, categoria, cod_filial));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }

}
