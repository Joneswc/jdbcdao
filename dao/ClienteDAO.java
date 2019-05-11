package javadb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadb.jdbc.ConnectionFactory;
import javadb.modelo.Cliente;

public class ClienteDAO {
	private Connection con;

	public ClienteDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void inserir(Cliente cliente) {
		String sql = "INSERT INTO clientes (nome, email, endereco) VALUES (?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getEmail());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> getClientes() {
		try {
			List<Cliente> clientes = new ArrayList<>();
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM clientes");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void fecharConexao() {
		try {
			this.con.close();
			System.out.println("A conexao com o banco foi fechada!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
