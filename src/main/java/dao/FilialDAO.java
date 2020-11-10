package dao;

import bd.ConexaoDB;
import entidade.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;
import servlet.ClienteServlet;

public class FilialDAO {

    public static List<Filial> getFiliais() {
        List<Filial> listaFiliais = new ArrayList();
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from filial";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("cod_filial");
                String nome = rs.getString("nome");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                listaFiliais.add(new Filial(codigo, nome, estado, cidade));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaFiliais;
    }

    public static void addFilial(Filial filial) throws SQLException, ClassNotFoundException {

        Connection con = ConexaoDB.getConexao();

        String query = "insert into filial(nome, estado, cidade) values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, filial.getNome());
        ps.setString(2, filial.getEstado());
        ps.setString(3, filial.getCidade());
        ps.execute();
    }

    public static void updateFilial(Filial filial) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.getConexao();
        String query = "update filial set nome=?, estado=?, cidade=? where cod_filial=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, filial.getNome());
        ps.setString(2, filial.getEstado());
        ps.setString(3, filial.getCidade());
        ps.setInt(4, filial.getCodigo());
        ps.execute();
    }

    public static void deletarFilial(int codigo) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.getConexao();
        String query = "delete from filial where cod_filial=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, codigo);
        ps.execute();
    }

    public static Filial getFilial(int codigo) {
        Filial filial = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from filial where cod_filial=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                filial = new Filial(codigo, nome, estado, cidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return filial;
    }

}
