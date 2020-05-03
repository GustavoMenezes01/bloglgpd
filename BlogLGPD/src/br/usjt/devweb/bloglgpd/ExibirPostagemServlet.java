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

@WebServlet("/Index")
public class ExibirPostagemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// private RepositoryPostagem repositoryPostagem;

//	public ExibirPostagemServlet() {
//		super();
//		repositoryPostagem = (RepositoryPostagem) new BlogDAO();
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// int numeroPagina = Integer.parseInt(request.getParameter("pagina"));
		int offset = 0;
		if (request.getParameter("offset") != null) {
			offset = Integer.parseInt(request.getParameter("offset"));
		}
		BlogDAO dao = new BlogDAO();

		try {
			ArrayList<Postagem> postsLiberados = dao.getPostsLiberadosPaginado(offset);
			int totalPosts = dao.totalRegistros();
			request.setAttribute("postsLiberados", postsLiberados);
			request.setAttribute("totalPosts", totalPosts);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			throw new ServletException("N�o foi possivel obter posts do banco", e);
		}
	}
}
