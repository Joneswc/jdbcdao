package javadb.testes;

import javadb.dao.ClienteDAO;
import javadb.modelo.Cliente;

public class TesteInsertDadosDao {

	public static void main(String[] args) {
		ClienteDAO dao = null;

		try {
			Cliente cliente = new Cliente();

			cliente.setNome("Joao");
			cliente.setEmail("joao@joao.com");
			cliente.setEndereco("Av. Sao Joao, 500");

			dao = new ClienteDAO();

			dao.inserir(cliente);

			System.out.println("Cliente gravado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao gravar cliente!");
			throw new RuntimeException();
		} finally {
			dao.fecharConexao();
		}
	}

}
