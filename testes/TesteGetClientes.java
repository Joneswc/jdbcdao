package javadb.testes;

import java.util.List;

import javadb.dao.ClienteDAO;
import javadb.modelo.Cliente;

public class TesteGetClientes {
	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.getClientes();
		for (Cliente cliente : clientes) {
			System.out.println("ID: " + cliente.getId() +
					", Nome: " + cliente.getNome() +
					", Email: " + cliente.getEmail() +
					", Endereço: " + cliente.getEndereco()
					);
		}
		dao.fecharConexao();
	}

}
