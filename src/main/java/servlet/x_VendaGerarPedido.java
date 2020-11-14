package servlet;

import dao.VendaDAO;
import entidade.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class x_VendaGerarPedido extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        String cpf = request.getParameter("cpf");
//        int codigoFilial = Integer.parseInt(request.getParameter("codigoFilial"));
//        Date dataVenda = new Date();
//
//        //Venda venda = new Venda(cpf, codigoFilial, dataVenda);
//
//        try {
//            //venda = VendaDAO.GerarPedidoVenda(venda);
//                      
//            int idVenda = venda.getId_venda();
//            
//            request.setAttribute("idVenda", idVenda);
//            request.setAttribute("codigoFilial", codigoFilial);
//            
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/vendaProduto.jsp");
//            rd.forward(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(VendaGerarPedido.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(VendaGerarPedido.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}