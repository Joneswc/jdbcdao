package javadb.testes;

import javadb.dao.ClienteDAO;
import javadb.modelo.Cliente;

public class TesteExcluirCliente {

	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		try {
			Cliente cliente = dao.pesquisaClientePorID(1);
			if (cliente.getId() == null) {
				System.out.println("ID inexistente!");
			} else {
				dao.excluir(cliente);
				dao.fecharConexao();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
