package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Postagem;

public class BlogDAO {
	public int criar(Postagem postagem) {
		String sqlInsert = "INSERT INTO POSTAGEM(AUTOR_POSTAGEM, TITULO_POSTAGEM, MENSAGEM_POSTAGEM, DATA_POSTAGEM) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, postagem.getAutor());
			stm.setString(2, postagem.getTitulo());
			stm.setString(3, postagem.getTexto());
			stm.setDate(4, (Date) postagem.getData());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					postagem.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postagem.getId();
	}

	public void atualizar(Postagem postagem) {
		String sqlUpdate = "UPDATE POSTAGEM SET AUTOR_POSTAGEM=?, TITULO_POSTAGEM=?, MENSAGEM_POSTAGEM=?, DATA_POSTAGEM=?, EXIBIR=? WHERE ID_POSTAGEM=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, postagem.getAutor());
			stm.setString(2, postagem.getTitulo());
			stm.setString(3, postagem.getTexto());
			stm.setDate(4, (Date) postagem.getData());
			stm.setBoolean(5, postagem.isExibir());
			stm.setInt(6, postagem.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM POSTAGEM WHERE ID_POSTAGEM = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Postagem carregar(int id) {
		Postagem postagem = new Postagem();
		postagem.setId(id);
		String sqlSelect = "SELECT AUTOR_POSTAGEM, TITULO_POSTAGEM, MENSAGEM_POSTAGEM, DATA_POSTAGEM FROM POSTAGEM WHERE POSTAGEM.ID_POSTAGEM = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, postagem.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					postagem.setAutor(rs.getString("AUTOR_POSTAGEM"));
					postagem.setTitulo(rs.getString("TITULO_POSTAGEM"));
					postagem.setTexto(rs.getString("MENSAGEM_POSTAGEM"));
					postagem.setData(rs.getDate("DATA_POSTAGEM"));
				} else {
					postagem.setId(-1);
					postagem.setAutor(null);
					postagem.setTitulo(null);
					postagem.setTexto(null);
					postagem.setData(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return postagem;
	}

	public ArrayList<Postagem> getAllPosts() throws SQLException {

		ArrayList<Postagem> allPosts = new ArrayList<>();

		String sqlList = ("SELECT ID_POSTAGEM, AUTOR_POSTAGEM, TITULO_POSTAGEM, MENSAGEM_POSTAGEM, DATA_POSTAGEM FROM POSTAGEM order by DATA_POSTAGEM desc");

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlList);) {
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Postagem postagem = new Postagem();
				postagem.setId(rs.getInt("ID_POSTAGEM"));
				postagem.setAutor(rs.getString("AUTOR_POSTAGEM"));
				postagem.setTitulo(rs.getString("TITULO_POSTAGEM"));
				postagem.setTexto(rs.getString("MENSAGEM_POSTAGEM"));
				try {
					postagem.setData(new java.util.Date(rs.getDate("DATA_POSTAGEM").getTime()));
				} catch (Exception e) {
					e.printStackTrace();
				}

				allPosts.add(postagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allPosts;
	}

	public void atualizarStatus(Postagem postagem) {
		String sqlUpdate = "UPDATE POSTAGEM SET EXIBIR=? WHERE ID_POSTAGEM=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setBoolean(1, postagem.isExibir());
			stm.setInt(2, postagem.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Postagem> getPostsLiberados() throws SQLException {

		ArrayList<Postagem> allPostsLiberados = new ArrayList<>();

		String sqlList = ("SELECT ID_POSTAGEM, AUTOR_POSTAGEM, TITULO_POSTAGEM, MENSAGEM_POSTAGEM, DATA_POSTAGEM FROM POSTAGEM where EXIBIR=true order by DATA_POSTAGEM desc");

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlList);) {
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Postagem postagem = new Postagem();
				postagem.setId(rs.getInt("ID_POSTAGEM"));
				postagem.setAutor(rs.getString("AUTOR_POSTAGEM"));
				postagem.setTitulo(rs.getString("TITULO_POSTAGEM"));
				postagem.setTexto(rs.getString("MENSAGEM_POSTAGEM"));
				try {
					postagem.setData(new java.util.Date(rs.getDate("DATA_POSTAGEM").getTime()));
				} catch (Exception e) {
					e.printStackTrace();
				}

				allPostsLiberados.add(postagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allPostsLiberados;
	}
}
