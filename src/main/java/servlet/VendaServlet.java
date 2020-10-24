package servlet;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import entidade.Cliente;
import entidade.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Douglas
 */
public class VendaServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
//        List<Produto> listaProduto = null;
//
//        try {
//            listaProduto = ProdutoDAO.getProdutos();
//        } catch (SQLException ex) {
//            Logger.getLogger(listaProduto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        request.setAttribute("listaVenda", listaProduto);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/venda.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf_cliente = request.getParameter("cpf_cliente");
        Cliente cliente = ClienteDAO.getCliente(cpf_cliente);
        request.setAttribute("cliente", cliente);
        
//        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
//        Produto produto = ProdutoDAO.getProduto(cod_produto);
//        request.setAttribute("produto", produto);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/venda.jsp");
        rd.forward(request, response);
    }
}
