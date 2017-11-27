package br.edu.univas.si8.ta.hello.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cadastro")
public interface CadastroService {
	@GET
	@Path("/cliente/names")
	@Produces(MediaType.APPLICATION_JSON)
	String[] listClieteNames();

	@POST
	@Path("/cliente/{name}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	String saveNewCliente(@PathParam("name") String name, @PathParam("email") String email);
}
