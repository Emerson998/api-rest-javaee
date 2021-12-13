package br.com.magna.pea2.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.magna.pea2.dto.ClienteDto;
import br.com.magna.pea2.model.ClienteModel;
import br.com.magna.pea2.service.ClienteService;


@Path("/cliente")
public class ClienteController {

	@PersistenceContext(unitName = "PostgresqlDS")
	private EntityManager em;

	@Inject
	private ClienteService clienteService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ClienteDto> dislplayAll() {
		try {
			return clienteService.all();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ClienteDto searchByCpf(@PathParam("cpf") String cpf) {
		try {
			return clienteService.searchByCpf(cpf);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(ClienteModel cliente) {
		try {
			clienteService.saveClienteDao(cliente);
			return Response.ok().build();
		} catch (EntityNotFoundException ex) {
			throw ex;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@PUT
	@Transactional
	@Path("/{cpf}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response change(@PathParam("cpf") String cpf, ClienteDto clienteDto) {
		try {
			ClienteDto dto = clienteService.change(cpf, clienteDto);
			return Response.ok(dto).build();
		} catch (EntityNotFoundException ex) {
			ex.getMessage();
			return Response.noContent().build();
		} catch (Exception ex) {
			ex.getMessage();
			return Response.noContent().build();
		}
	}

	@DELETE
	@Path("/{cpf}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("cpf") String cpf) {
		try {
			clienteService.delete(cpf);
			return Response.ok().build();
		} catch (NotFoundException ex) {
			return Response.noContent().build();
		}

	}

}
