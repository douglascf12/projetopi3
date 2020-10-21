/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entidade.Produto;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Servlet extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        
        response.setContentType("text/html;charset=utf-8");
        
        try(PrintWriter out = response.getWriter()){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            List<Cliente> listaClientes = ClienteDAO.getClientes();
            for(Cliente cliente: listaClientes) {
                out.println(cliente);
                out.println("<br/>");
            }
            
            List<Produto> listaProduto = ProdutoDAO.getProdutos();
            for (Produto produto: listaProduto) {
                out.println(produto);
                
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
   
}
