package dao;

import bd.ConexaoDB;
import java.sql.Connection;
import entidade.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.ServletFunc;
import utils.CargoEnum;

public class FuncionarioDAO {

    public static List<Funcionario> getFuncionario() {
        List<Funcionario> listaFuncionarios = new ArrayList();
        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "select * from funcionario";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCpfFunc(rs.getString("cpf_func"));
                funcionario.setNomeFunc(rs.getString("nome"));
                funcionario.setCodFilial(rs.getInt("cod_filial"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setTelefoneFunc(rs.getString("telefone"));
                funcionario.setEnderecoFunc(rs.getString("endereco"));
                funcionario.setDataNascFunc(rs.getString("data_nasc"));
                funcionario.setSexoFunc(rs.getString("sexo"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                listaFuncionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFuncionarios;
    }

    public static void updateFuncionario(Funcionario funcionario) throws SQLException {
        Connection con = ConexaoDB.getConexao();
        String query = "update funcionario set nome=?, cod_filial=?, cargo=?, telefone=?, endereco=?, data_nasc=?, sexo=?, usuario=?, senha=? where cpf_func=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getNomeFunc());
        ps.setInt(2, funcionario.getCodFilial());
        ps.setString(3, funcionario.getCargo());
        ps.setString(4, funcionario.getTelefoneFunc());
        ps.setString(5, funcionario.getEnderecoFunc());
        ps.setString(6, funcionario.getDataNascFunc());
        ps.setString(7, funcionario.getSexoFunc());
        ps.setString(8, funcionario.getUsuario());
        ps.setString(9, funcionario.getSenha());
        ps.setString(10, funcionario.getCpfFunc());
        ps.execute();
    }

    public static Funcionario getFunc(String cpf) {
        Funcionario funcionario = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from funcionario where cpf_func=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCpfFunc(cpf);
                funcionario.setNomeFunc(rs.getString("nome"));
                funcionario.setCodFilial(rs.getInt("cod_filial"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setTelefoneFunc(rs.getString("telefone"));
                funcionario.setEnderecoFunc(rs.getString("endereco"));
                funcionario.setDataNascFunc(rs.getString("data_nasc"));
                funcionario.setSexoFunc(rs.getString("sexo"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public static Funcionario getFuncLogin(String usuario) {
        Funcionario funcionario = null;
        try {
            java.sql.Connection con = ConexaoDB.getConexao();
            String query = "select * from funcionario where usuario=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cpf = rs.getString("cpf_func");
                String nome = rs.getString("nome");
                int codFilial = rs.getInt("cod_filial");
                String cargo = rs.getString("cargo");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                String datanasc = rs.getString("data_nasc");
                String sexo = rs.getString("sexo");
                String senha = rs.getString("senha");
                funcionario = new Funcionario(cpf, nome, codFilial, cargo, telefone, endereco, datanasc, sexo, usuario, senha);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public static void addFuncionario(Funcionario funcionario) throws SQLException {
        String query = null;
        Connection con = ConexaoDB.getConexao();
        if (funcionario.getCodFilial() == -1) {
            query = "insert into funcionario(cpf_func, nome, cargo, telefone, endereco, data_nasc, sexo, usuario, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getCpfFunc());
            ps.setString(2, funcionario.getNomeFunc());
            ps.setString(3, funcionario.getCargo());
            ps.setString(4, funcionario.getTelefoneFunc());
            ps.setString(5, funcionario.getEnderecoFunc());
            ps.setString(6, funcionario.getDataNascFunc());
            ps.setString(7, funcionario.getSexoFunc());
            ps.setString(8, funcionario.getUsuario());
            ps.setString(9, funcionario.codificarSenha(funcionario.getSenha()));
            ps.execute();
        } else {
            query = "insert into funcionario(cpf_func, nome, cod_filial, cargo, telefone, endereco, data_nasc, sexo, usuario, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, funcionario.getCpfFunc());
            ps.setString(2, funcionario.getNomeFunc());
            ps.setInt(3, funcionario.getCodFilial());
            ps.setString(4, funcionario.getCargo());
            ps.setString(5, funcionario.getTelefoneFunc());
            ps.setString(6, funcionario.getEnderecoFunc());
            ps.setString(7, funcionario.getDataNascFunc());
            ps.setString(8, funcionario.getSexoFunc());
            ps.setString(9, funcionario.getUsuario());
            ps.setString(10, funcionario.codificarSenha(funcionario.getSenha()));
            ps.execute();
        }

    }

    public static void deleteFuncionario(String cpf) throws SQLException {
        Connection con = ConexaoDB.getConexao();
        String query = "delete from funcionario where cpf_func=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cpf);
        ps.execute();
    }

}
