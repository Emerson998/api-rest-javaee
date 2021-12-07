package br.com.magna.pea2.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.magna.pea2.model.LocadoraModel;
import br.com.magna.pea2.service.LocadoraService;

@Path("/locadora")
public class LocadoraController {

	@PersistenceContext(unitName = "PostgresqlDS")
	private EntityManager em;

	@Inject
	private LocadoraService locadoraService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(LocadoraModel locadora) {
		try {
			locadoraService.salvarLocadoraDao(locadora);
			return Response.ok().build();
		} catch (NotFoundException ex) {
			ex.getMessage();
			return Response.noContent().build();
		}
	}

//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public void post(LocadoraDto locadoraDto) {
//		locadoraService.add(locadoraDto);
//	}

}
