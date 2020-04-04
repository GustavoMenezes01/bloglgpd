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

		if (password.equals("admin123")) {
			request.getRequestDispatcher("moderacao.jsp").include(request, response);
			out.print("Bem Vindo, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else if (password != "admin123") {
			request.getRequestDispatcher("cadastro.jsp").include(request, response);
			out.print("Bem Vindo, " + name);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else {
			out.print("Desculpe, Usuário ou Senha Inválidos! ");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
	}
}