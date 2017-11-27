package br.edu.univas.si8.ta.hello.ejb.beans;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.edu.univas.si8.ta.hello.ejb.dao.ClienteDAO;
import br.edu.univas.si8.ta.hello.ejb.entities.Cliente;
import br.edu.univas.si8.ta.hello.ejb.interfaces.CadastroLocal;
import br.edu.univas.si8.ta.hello.ejb.interfaces.CadastroRemote;



@Stateless
@Local(CadastroLocal.class)
@Remote(CadastroRemote.class)
public class CadastroBean implements CadastroLocal, CadastroRemote{

	@EJB
	private ClienteDAO dao;
	
	@Override
	public void createNewCliente(String clienteName, String clienteEmail) {
		Cliente cliente = new Cliente();
		cliente.setName(clienteName);
		cliente.setEmail(clienteEmail);
		dao.insert(cliente);
		
	}

	@Override
	public String[] listClienteNames() {
		return dao.listAll()
				.stream()
				.map(Cliente::getName)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

	@Override
	public String[] listClienteEmail() {
		return dao.listAll()
				.stream()
				.map(Cliente::getEmail)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}
	
	
	

}
