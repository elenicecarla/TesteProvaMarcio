package br.edu.univas.si8.ta.hello.rest.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.edu.univas.si8.ta.hello.ejb.interfaces.Cadastro;
import br.edu.univas.si8.ta.hello.rest.api.CadastroService;

@RequestScoped
public class CadastroServiceImpl implements CadastroService {

	@EJB(mappedName = "java:app/hello-rest-ejb-0.1-SNAPSHOT/CadastroBean!br.edu.univas.si8.ta.hello.ejb.interfaces.CadastroRemote")
	private Cadastro cadastro;
	
	@Override
	public String[] listClieteNames() {
		return cadastro.listClienteNames();
	}

	@Override
	public String saveNewCliente(String name, String email) {
		cadastro.createNewCliente(name, email);
		return "{\"message\": \"Success\"}";
	}



}
