package dao;

import bd.ConexaoDB;
import entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;



public class ProdutoDAO {
    
     public static List<Produto> getProdutos() throws SQLException {
        List<Produto> listaProdutos = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_produto = rs.getInt("cod_produto");
                String descricao = rs.getString("descricao");
                String nome_produto = rs.getString("nome_produto");
                int qtd_estoque = rs.getInt("qtd_estoque");
                float preco = rs.getFloat("preco");
                listaProdutos.add(new Produto(cod_produto, descricao, nome_produto, qtd_estoque, preco));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
    }
}
