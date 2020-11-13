package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClienteDAO;
import entidade.Cliente;
import entidade.Venda;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        request.setAttribute("cliente", cliente);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/venda.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        request.setAttribute("cpf", cpf);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/vendaCarrinho.jsp");
        rd.forward(request, response);

        /*String cpfCliente = request.getParameter("cpf");
        String cpfFuncionario = request.getParameter("cpf");
        String valorTotal = request.getParameter("cpf");
        int cod_filial = Integer.parseInt(request.getParameter("cpf"));
        
        //SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");       
        //String formatted = format1.format(cal.getTime());
        

        Venda venda = new Venda(0, cpfCliente, cpfFuncionario, 0, Calendar.getInstance().getTime());
        Cliente cliente = ClienteDAO.getCliente(cpf);
        request.setAttribute("cliente", cliente);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/venda.jsp");
        rd.forward(request, response);*/
    }

    

}
