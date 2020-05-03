package br.usjt.devweb.bloglgpd.service;



import br.usjt.devweb.bloglgpd.dao.BlogDAO;
import br.usjt.devweb.bloglgpd.model.Postagem;

public class BlogService {
	BlogDAO dao = new BlogDAO();
	
	public int criar(Postagem postagem) {
		return dao.criar(postagem);
	}
	
	public void atualizar(Postagem postagem) {
		dao.atualizar(postagem);
	}
	
	public void excluir(int id) {
		dao.excluir(id);
	}
	
	public Postagem carregar(int id) {
		return dao.carregar(id);
	}
	
	public void atualizarStatus(Postagem postagem) {
		dao.atualizarStatus(postagem);
	}
}
