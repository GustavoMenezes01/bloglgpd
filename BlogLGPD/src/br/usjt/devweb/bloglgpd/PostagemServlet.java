package br.usjt.devweb.bloglgpd;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Postagem;
import service.BlogService;

@WebServlet("/PostagemServlet")
public class PostagemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pAutor = request.getParameter("AUTOR_POSTAGEM");
		String pTitulo = request.getParameter("TITULO_POSTAGEM");
		String pTexto = request.getParameter("MENSAGEM_POSTAGEM");
		String pData = request.getParameter("DATA_POSTAGEM");
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Date startDate = (Date) sdf.parse(pData);

		// instanciar o javabean
		Postagem postagem = new Postagem();
		postagem.setAutor(pAutor);
		postagem.setTitulo(pTitulo);
		postagem.setTexto(pTexto);
		postagem.setData(pData);

		// instanciar o service
		BlogService bs = new BlogService();
		bs.criar(postagem);
		postagem = bs.carregar(postagem.getId());

		// enviar para JSP
		request.setAttribute("postagem", postagem);
		RequestDispatcher view = request.getRequestDispatcher("testeExibePostagem.jsp");
		view.forward(request, response);
	}
}
