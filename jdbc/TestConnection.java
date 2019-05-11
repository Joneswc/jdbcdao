package javadb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("ok, connecção aberta");
		con.close();
	}

}
