package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Postagem;

public class BlogDAO {
	public int criar(Postagem postagem) {
		String sqlInsert = "INSERT INTO POSTAGEM(AUTOR_POSTAGEM, TITULO_POSTAGEM, MENSAGEM_POSTAGEM, DATA_POSTAGEM) VALUES (?, ?, ?, ?)"; 
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, postagem.getAutor());
			stm.setString(2, postagem.getTitulo());
			stm.setString(3, postagem.getTexto());
			stm.setDate(4, (Date) postagem.getData());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
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
		String sqlUpdate = "UPDATE POSTAGEM SET AUTOR_POSTAGEM=?, TITULO_POSTAGEM=?, MENSAGEM_POSTAGEM=?, DATA_POSTAGEM=?, WHERE ID_POSTAGEM=?"; 
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, postagem.getAutor());
			stm.setString(2, postagem.getTitulo());
			stm.setString(3, postagem.getTexto());
			stm.setDate(4, (Date) postagem.getData());
			stm.setInt(5, postagem.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM POSTAGEM WHERE ID_POSTAGEM = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
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
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
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
}
