package br.usjt.devweb.bloglgpd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin123") && !name.isEmpty()) {
			request.getRequestDispatcher("moderacao.jsp").include(request, response);
			out.print("Bem Vindo, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else if (password != "admin123" && !password.isEmpty() && !name.isEmpty()) {
			request.getRequestDispatcher("cadastro.jsp").include(request, response);
			out.print("Bem Vindo, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else if (name.isEmpty()) {
			out.print("Desculpe, informar login.");
			request.getRequestDispatcher("login.jsp").include(request, response);			
		} else if(password.isEmpty()){
			out.print("Desculpe, informar senha.");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}else {
			out.print("Desculpe, Usuário ou Senha Inválidos! ");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
	}
}