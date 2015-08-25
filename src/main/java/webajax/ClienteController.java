package webajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cli.do")
public class ClienteController extends HttpServlet {

	
	private static List<Cliente> lista = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String i =  req.getParameter("i");
		if(i!=null && !i.isEmpty()){
			lista.remove(Integer.parseInt(i));
		}
		
		String json = JsonUtil.objetoParaJson(lista);
		resp.getWriter().print( json) ;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		
		Cliente cliente = new Cliente(nome, email);
		lista.add(cliente);
		
		String json = JsonUtil.objetoParaJson(lista);
		resp.getWriter().print( json) ;
	
	}
}
