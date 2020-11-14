/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
import dao.VendaDAO;
import entidade.Cliente;
import entidade.Funcionario;
import entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author w_olv
 */
public class CadastrarVendaServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Double total_venda = Double.parseDouble(request.getParameter("valorTotal"));
        
        HttpSession sessao = request.getSession();
        Funcionario funcionario;
        Cliente cliente;
        funcionario= (Funcionario) sessao.getAttribute("user");
        cliente= (Cliente) sessao.getAttribute("cliente");

        //SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");       
        //String formatted = format1.format(cal.getTime());
        Venda venda = new Venda(total_venda, cliente.getCpf_cliente(), funcionario.getCpfFunc(), funcionario.getCodFilial(), Calendar.getInstance().getTime());
        try {
            VendaDAO.GerarPedidoVenda(venda);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //request.setAttribute("cliente", cliente);
          response.sendRedirect("sucesso.jsp");
    }
}
