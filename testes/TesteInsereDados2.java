package javadb.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javadb.jdbc.ConnectionFactory;

public class TesteInsereDados2 {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement stmt;
		try {
			con = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO clientes (nome, email, endereco) VALUES (?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "Maria");
			stmt.setString(2, "maria@maria.com");
			stmt.setString(3, "Av. Brasil, 100");
			stmt.execute(); // executa código
			stmt.close(); // commita as execuções
			System.out.println("Gravado com sucesso!");
//			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

}
