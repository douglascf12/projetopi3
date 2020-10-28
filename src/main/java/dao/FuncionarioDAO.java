package dao;

import bd.ConexaoDB;
import com.sun.jndi.ldap.Connection;
import entidade.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.ServletFunc;

public class FuncionarioDAO {

    public static List<Funcionario> getFuncionario() {
        List<Funcionario> listaFuncionarios = new ArrayList();

        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "select * from funcionario";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String cpfStr = rs.getString("cpf_func");
                int cpf = Integer.parseInt(cpfStr);
                String nome = rs.getString("nome");
                String datanasc = rs.getString("data_nasc");
                String telefoneStr = rs.getString("telefone");
                int telefone = Integer.parseInt(telefoneStr);
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                listaFuncionarios.add(new Funcionario(cpf, nome, datanasc, telefone, endereco, sexo));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFuncionarios;

    }

    public static boolean updateFuncionario(Funcionario funcionario) {

        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "upadate cliente set cpf_cliente=? , nome=? , data_nasc=? , telefone=? , endereco=? , sexo=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, funcionario.getCpfFunc());
            ps.setString(2, funcionario.getNomeFunc());
            ps.setString(3, funcionario.getDataNascFunc());
            ps.setInt(4, funcionario.getTelefoneFunc());
            ps.setString(5, funcionario.getEnderecoFunc());
            ps.setString(6, funcionario.getSexoFunc());
            
            boolean ok = ps.execute();
            return ok;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static Funcionario getFunc(String nome) {
        Funcionario funcionario = null;
        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "select * from cliente where nome=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String cpfStr = rs.getString("cpf_func");
                int cpf = Integer.parseInt(cpfStr);
                String datanasc = rs.getString("data_nasc");
                String telefoneStr = rs.getString("telefone");
                int telefone = Integer.parseInt(telefoneStr);
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                funcionario = new Funcionario(cpf, nome, datanasc, telefone, endereco, sexo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public static boolean addFuncionario(Funcionario funcionario) {
        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "insert into funcionario (cpf_cliente , nome , data_nasc , telefone , endereco , sexo) values (? , ? , ? , ? ,? , ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, funcionario.getCpfFunc());
            ps.setString(2, funcionario.getNomeFunc());
            ps.setString(3, funcionario.getDataNascFunc());
            ps.setInt(4, funcionario.getTelefoneFunc());
            ps.setString(5, funcionario.getEnderecoFunc());
            ps.setString(6, funcionario.getSexoFunc());
            boolean ok = ps.execute();
            return ok;

        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean deleteFuncionario(String nome) {

        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "delete from funcionario where nome=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nome);

            boolean ok = ps.execute();
            return ok;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
