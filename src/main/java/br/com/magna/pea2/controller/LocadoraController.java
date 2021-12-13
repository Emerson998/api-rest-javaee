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

import br.com.magna.pea2.dto.LocadoraDto;
import br.com.magna.pea2.model.LocadoraModel;
import br.com.magna.pea2.service.LocadoraService;

@Path("/locadora")
public class LocadoraController {

	@PersistenceContext(unitName = "PostgresqlDS")
	private EntityManager em;

	@Inject
	private LocadoraService locadoraService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<LocadoraDto> dislplayAll() {
		try {
			return locadoraService.all();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GET
	@Path("/{cnpj}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LocadoraDto searchByCnpj(@PathParam("cnpj") String cnpj) {
		try {
			return locadoraService.searchByCnpj(cnpj);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(LocadoraModel locadora) {
		try {
			locadoraService.saveLocadoraDao(locadora);
			return Response.ok().build();
		} catch (EntityNotFoundException ex) {
			throw ex;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@PUT
	@Transactional
	@Path("/{cnpj}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response change(@PathParam("cnpj") String cnpj, LocadoraDto locadoraDto) {
		try {
			LocadoraDto dto = locadoraService.change(cnpj, locadoraDto);
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
	@Path("/{cnpj}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("cnpj") String cnpj) {
		try {
			locadoraService.delete(cnpj);
			return Response.ok().build();
		} catch (NotFoundException ex) {
			return Response.noContent().build();
		}

	}

}
