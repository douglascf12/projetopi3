/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoDB;
import entidade.DetalheVenda;
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
import servlet.DetalharVenda;

/**
 *
 * @author w_olv
 */
public class RelatorioVendaDAO {

    public static List<Venda> getRelatorioVenda() throws SQLException {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from venda";
            PreparedStatement ps = con.prepareStatement(query);
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

    public static List<DetalheVenda> getDetalheRelatorioVenda(int id) throws SQLException {
        List<DetalheVenda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();

            String query = "select * from detalhes_venda where id_venda=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int qtd_vendida = rs.getInt("qtd_vendida");
                Date data_venda = rs.getDate("data_venda");
                int cod_produto = rs.getInt("cod_produto");
                listaVendas.add(new DetalheVenda(cod_produto, data_venda, qtd_vendida));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
}
