/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoDB;
import entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.ServletCliente;

/**
 *
 * @author andre
 */
public class ClienteDAO {
    
    
        public static List<Cliente> getClientes() {
        
            List<Cliente> listaClientes = new ArrayList();
        
            
            Connection con;
            try {
                con = ConexaoDB.getConexao();
           
            String query = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String dataNascimento = rs.getString("dataNascimento");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                listaClientes.add(new Cliente(nome, email, cpf, dataNascimento,endereco, sexo));
            }
           } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        return listaClientes;
    
}
        
          public static void adicionarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
              
        Connection con = ConexaoDB.getConexao();
        String query = "insert into cliente(nome, email, cpf, dataNascimento, endereco, sexo) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getDataNascimento());
        ps.setString(5, cliente.getEndereco());
        ps.setString(6, cliente.getSexo());
        ps.execute();
    }

        public static void atualizarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
               
        Connection con = ConexaoDB.getConexao();
        String query = "update cliente set nome=?,email=?,dataNascimento=?,endereco=?,sexo=? where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
       ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getDataNascimento());
        ps.setString(5, cliente.getEndereco());
        ps.setString(6, cliente.getSexo());
        ps.execute();
    }
    
        public static void ExcluirCliente(String cpf) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.getConexao();
        String query = "delete from cliente where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cpf);
        ps.execute();
    }
        
         public static Cliente getCliente(String cpf) {
        Cliente cliente = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from cliente where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String dataNascimento = rs.getString("dataNascimento");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                cliente = new Cliente(nome, email, cpf, dataNascimento, endereco, sexo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletCliente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
}