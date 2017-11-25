package com.logistica;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/apiEntregas")
public class EntregasService {

	@GET
	@Path("/entregaId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEntregaById(@PathParam("id") String numeroPedido) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		EntregasModel entrega = null;
		try {
			Connection conn = connectionFactory.getConnection();
			EntregasDAO entregaDAO = new EntregasDAO();
			entrega = entregaDAO.getById(conn, numeroPedido);
			if (entrega.getId() == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.status(Response.Status.OK).entity(entrega).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(EntregasModel entrega){
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try {
			Connection conn = connectionFactory.getConnection();
			EntregasDAO entregaDAO = new EntregasDAO();
			if (entrega.getNumeroPedido() == null || entrega.getIdCliente() == null) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			entregaDAO.insert(conn, entrega);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
