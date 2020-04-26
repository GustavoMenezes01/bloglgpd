package br.usjt.devweb.bloglgpd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDAO;
import model.Postagem;


@WebServlet("/ModeracaoPostagemServlet")
public class ExibirPostagemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BlogDAO dao = new BlogDAO();
		
		try {			
			ArrayList<Postagem> postsLiberados = dao.getPostsLiberados();
			
			request.setAttribute("postsLiberados", postsLiberados);
			RequestDispatcher view = request.getRequestDispatcher("postagem.jsp");
			view.forward(request, response);
		}catch (Exception e) {
			throw new ServletException("Não foi possivel obter posts do banco", e);
		}
	}

}
