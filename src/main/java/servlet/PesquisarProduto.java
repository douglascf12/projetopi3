package servlet;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Douglas
 */
public class PesquisarProduto extends HttpServlet {

	private static final long serialVersionUID = 7003999203515802659L;
	private List<Produto> produtos;
	
	public PesquisarProduto(){
		produtos = new ArrayList<>();
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
        Produto produto = ProdutoDAO.getProduto(cod_produto);
        
        produtos.add(produto);
        
        request.setAttribute("produtos", produtos);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/venda.jsp");
        rd.forward(request, response);
        
    }

}