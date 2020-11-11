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
                String codFiliStr = rs.getString("cod_filial");
                int codFili = Integer.parseInt(codFiliStr);
                String cargo = rs.getString("cargo");
                String telefoneStr = rs.getString("telefone");
                int telefone = Integer.parseInt(telefoneStr);
                String endereco = rs.getString("endereco");
                String datanasc = rs.getString("data_nasc");
                String sexo = rs.getString("sexo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                listaFuncionarios.add(new Funcionario(cpf, nome,codFili, cargo , telefone, endereco,datanasc, sexo , usuario , senha));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFuncionarios;

    }

    public static boolean updateFuncionario(Funcionario funcionario) {

        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "upadate funcioanrio set cpf_func=? , nome=?, cod_filial=?, cargo=?, telefone=? , endereco=?, data_nasc=? , sexo=? , usuario=? , senhac=? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, funcionario.getCpfFunc());
            ps.setString(2, funcionario.getNomeFunc());
            ps.setInt(3, funcionario.getCodFilial());
            ps.setString(4,funcionario.getCargo());
             ps.setInt(5, funcionario.getTelefoneFunc());
            ps.setString(6, funcionario.getEnderecoFunc());
            ps.setString(7, funcionario.getDataNascFunc());
            ps.setString(8, funcionario.getSexoFunc());
            ps.setString(9, funcionario.getUsuario());
            ps.setString(10, funcionario.getSenha());
            
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
            String query = "select * from funcionario where nome=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nome);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String cpfStr = rs.getString("cpf_func");
                int cpf = Integer.parseInt(cpfStr);
                String codFiliStr = rs.getString("cod_filial");
                int codFili = Integer.parseInt(codFiliStr);
                String cargo = rs.getString("cargo");
                 String telefoneStr = rs.getString("telefone");
                int telefone = Integer.parseInt(telefoneStr);
                String endereco = rs.getString("endereco");
                String datanasc = rs.getString("data_nasc");
                String sexo = rs.getString("sexo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                funcionario = new Funcionario(cpf, nome,codFili,cargo, telefone, endereco, datanasc,  sexo , usuario , senha);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }
    
    public static Funcionario getFunc(String usuario, String senha) {
        Funcionario funcionario = null;
        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "select * from funcionario where usuario=? and senha=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cpfStr = rs.getString("cpf_func");
                int cpf = Integer.parseInt(cpfStr);
                String nome = rs.getString("nome");
                //String codFilialStr = rs.getString("cod_filial");
                //int codFilial = Integer.parseInt(codFilialStr);
                String cargo = rs.getString("cargo");
                //String datanasc = rs.getString("data_nasc");
                //String telefoneStr = rs.getString("telefone");
                //int telefone = Integer.parseInt(telefoneStr);
                //String endereco = rs.getString("endereco");
                //String sexo = rs.getString("sexo");
                funcionario = new Funcionario(cpf, nome, cargo, usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public static boolean addFuncionario(Funcionario funcionario) {
        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "insert into funcionario (cpf_cliente , nome , cod_filial, cargo , telefone , endereco ,  data_nasc ,  sexo , usuario , senha) values (? ,? ,? ,? ,? , ? , ? , ? ,? , ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, funcionario.getCpfFunc());
            ps.setString(2, funcionario.getNomeFunc());
            ps.setInt(3, funcionario.getCodFilial());
            ps.setString(4, funcionario.getCargo());
            ps.setInt(5, funcionario.getTelefoneFunc());
            ps.setString(6, funcionario.getEnderecoFunc());
            ps.setString(7, funcionario.getDataNascFunc());
            ps.setString(8, funcionario.getSexoFunc());
            ps.setString(9, funcionario.getUsuario());
            ps.setString(10, funcionario.getSenha());
            
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
