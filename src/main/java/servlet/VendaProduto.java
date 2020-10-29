package servlet;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String codigoFilial = request.getParameter("codigoFilial");
        String idVenda = request.getParameter("idVenda");
        int codigoProduto = Integer.parseInt(request.getParameter("codigoProduto"));
        
        Produto produto = ProdutoDAO.getProduto(codigoProduto);
        
        
        request.setAttribute("codigoFilial", codigoFilial);
        request.setAttribute("idVenda", idVenda);
        request.setAttribute("produto", produto);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/vendaProduto.jsp");
        rd.forward(request, response);
    }

}
