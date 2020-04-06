package br.usjt.devweb.bloglgpd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Postagem;

@WebServlet("/PostagemServlet")
public class PostagemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("testePostagem.jsp").include(request, response);

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("name") != null) {
			String name = (String) session.getAttribute("name");

			out.print("Olá, " + name + " Bem vindo a tela de postagem");
		} else {
			out.print("Por favor logue primeiro!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pTitulo = request.getParameter("titulo");
		String pTexto = request.getParameter("texto");
		
		//instanciar o javabean
		Postagem postagem = new Postagem();
		postagem.setTitulo(pTitulo);
		postagem.setTexto(pTexto);
		
		//enviar para JSP
		request.setAttribute("postagem", postagem);
		RequestDispatcher view = request.getRequestDispatcher("testeExibePostagem.jsp");
		view.forward(request, response);	
	}
}
