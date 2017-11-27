package br.edu.univas.si8.ta.hello.ejb.interfaces;

public interface Cadastro {
	void createNewCliente(String clienteName, String clienteEmail);

	String[] listClienteNames();
	String[] listClienteEmail();
}
