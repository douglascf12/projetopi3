package dao;

import bd.ConexaoDB;
import entidade.DetalheVenda;
import entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;

public class VendaDAO {

//    public static Venda GerarPedidoVenda(Venda venda) throws SQLException, ParseException {
//        PreparedStatement ps = null;
//        Connection con = ConexaoDB.getConexao();
//        try {
//            ps = con.prepareStatement("insert into venda (cpf_cliente, cpf_func, cod_filial, data_venda, total_venda, cod_filial) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");       
//            ps.setString(1, venda.getCpf_cliente());
//            ps.setString(2, venda.getCpf_func());
//            ps.setInt(3, venda.getCod_filial());
//            ps.setString(4, format1.format(venda.getData_venda()));
//            ps.setDouble(5, venda.getTotal_venda());
//            ps.executeUpdate();
//            ResultSet generatedKeys = ps.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                venda.setId_venda(generatedKeys.getInt(1));
//            } else {
//                throw new SQLException("Erro: Não foi possivel pegar o id da venda");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return venda;
//    }
    public static int finalizarVenda(Venda venda) throws SQLException, ParseException {
        int cod_venda = 0;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "insert into venda (cpf_cliente, cpf_func, cod_filial, data_venda, total_venda) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, venda.getCpf_cliente());
            ps.setString(2, venda.getCpf_func());
            ps.setInt(3, venda.getCod_filial());
            ps.setString(4, venda.getData_venda());
            ps.setDouble(5, venda.getTotal_venda());
            ps.execute();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                cod_venda = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Erro: Não foi possivel pegar o id da venda");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return cod_venda;
    }

    public static void finalizarDetalheVenda(DetalheVenda detalheVenda) throws SQLException, ParseException {
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "insert into detalhe_venda (id_venda, cod_produto, qtd_vendida, sub_total, nome) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, detalheVenda.getId_venda());
            ps.setInt(2, detalheVenda.getCod_produto());
            ps.setInt(3, detalheVenda.getQtd_vendida());
            ps.setFloat(4, detalheVenda.getSubTotal());
            ps.setString(5, detalheVenda.getNome());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
