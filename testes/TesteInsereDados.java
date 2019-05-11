package javadb.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javadb.jdbc.ConnectionFactory;

public class TesteInsereDados {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();

		String sql = "INSERT INTO clientes (nome, email, endereco) VALUES (?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1, "Maria");
		stmt.setString(2, "maria@maria.com");
		stmt.setString(3, "Av. Brasil, 100");

		stmt.execute();
		stmt.close();

		System.out.println("Gravado com sucesso!");

		con.close();

	}

}
