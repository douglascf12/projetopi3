package servlet;

import entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExcluirProdutoCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        int codProduto = Integer.parseInt(request.getParameter("codigo"));
        List<Produto> listaProdutos = (List<Produto>) sessao.getAttribute("listaProdutos");
        
        for(Produto p: listaProdutos) {
            if(p.getCod_produto() == codProduto) {
                listaProdutos.remove(p);
            }
        }
        sessao.removeAttribute("listaProdutos");
        sessao.setAttribute("listaProdutos", listaProdutos);
    }

}