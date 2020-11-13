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
        
        int codProduto = Integer.parseInt(request.getParameter("codProduto"));
        Produto produto = ProdutoDAO.getProduto(codProduto);
        
        request.setAttribute("produto", produto);        

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/vendaCarrinho.jsp");
        rd.forward(request, response);
    }

}
