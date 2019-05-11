package javadb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "");
			System.out.println("Connectado ao Banco de Dados Maria DB local");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
