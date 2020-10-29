package dao;

import bd.ConexaoDB;
import entidade.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;

public class ItemVendaDAO {

    public static void inserirItemVenda(ItemVenda item) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            ps = con.prepareStatement("insert into tb_itemvenda (codVenda,codProduto,quantidade,subTotal) values (?,?,?,?)");

            ps.setInt(1, item.getCodVenda());
            ps.setInt(2, item.getCodProduto());
            ps.setInt(3, item.getQuantidade());
            ps.setDouble(4, item.getSubTotal());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static List<ItemVenda> getItemVenda(int codVenda) {
        PreparedStatement ps = null;
        List<ItemVenda> listaItemVenda = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select tb_itemvenda.idItem, tb_itemvenda.codProduto, tb_produto.nomeProduto, tb_produto.marcaProduto,tb_itemvenda.quantidade, tb_produto.valorProduto, tb_itemvenda.subTotal\n"
                    + "from tb_produto, tb_itemvenda\n"
                    + "where tb_produto.codProduto = tb_itemvenda.codProduto and tb_itemvenda.codVenda = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codVenda);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codItemVenda = rs.getInt("idItem");
                int codProduto = rs.getInt("codProduto");
                String nomeProduto = rs.getString("nomeProduto");
                String marcaProduto = rs.getString("marcaProduto");
                int quantidade = rs.getInt("quantidade");
                double valorProduto = rs.getDouble("valorProduto");
                double subTotal = rs.getDouble("subTotal");
                listaItemVenda.add(new ItemVenda(codItemVenda, codProduto, nomeProduto, marcaProduto, quantidade, valorProduto, subTotal));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaItemVenda;
    }

    public static void excluirItemVenda(int idItem, int codProduto, int quantidade) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.getConexao();
        String query = "update tb_produto set quantidadeEmEstoque = quantidadeEmEstoque + ? where codProduto=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, quantidade);
        ps.setInt(2, codProduto);
        ps.execute();

        query = "delete from tb_itemVenda where idItem=?";
        ps = con.prepareStatement(query);
        ps.setInt(1, idItem);
        ps.execute();
    }
}
