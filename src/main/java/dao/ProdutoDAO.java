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
            String query = "select * from produto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cod_produto = rs.getInt("cod_produto");
                float preco = rs.getFloat("preco");
                String descricao = rs.getString("descricao");
                int qtd_estoque = rs.getInt("qtd_estoque");
                String nome_produto = rs.getString("nome_produto");
                listaProdutos.add(new Produto(cod_produto, descricao, nome_produto, qtd_estoque,  preco));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
    }

    public static void addProduto(Produto produto) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.getConexao();
        String query = "insert into produto(preco,descricao,qtd_estoque,nome_produto) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setFloat(1, produto.getPreco());
        ps.setString(2, produto.getDescricao());
        ps.setInt(3, produto.getQtd_estoque());
        ps.setString(4, produto.getNome_produto());
        ps.execute();
    }

    public static void updateProduto(Produto produto) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.getConexao();
        String query = "update produto set preco=?,descricao=?,qtd_estoque=?,nome_produto=? where cod_produto=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setFloat(1, produto.getPreco());
        ps.setString(2, produto.getDescricao());
        ps.setInt(3, produto.getQtd_estoque());
        ps.setString(4, produto.getNome_produto());
        ps.setInt(5,produto.getCod_produto());
        ps.execute();
    }

    public static void deletaProduto(int cod_produto) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.getConexao();
        String query = "delete from produto where cod_produto=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, cod_produto);
        ps.execute();
    }

    public static Produto getProduto(int cod_produto) {
        Produto produto = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from produto where cod_produto=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cod_produto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Float preco = rs.getFloat("preco");
                String descricao = rs.getString("descricao");
                int qtd_estoque = rs.getInt("qtd_estoque");
                String nome_produto = rs.getString("nome_produto");
                produto = new Produto(cod_produto,descricao, nome_produto, qtd_estoque,  preco);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}
