package ru.parcel.system.rest.resources;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ru.parcel.system.dao.TransporterEJB;
import ru.parcel.system.entities.Transporter;

@Path("transporters") // ../api/v1/transporters
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Stateless // Mark the resource with ejb annotation @Stateless to make it ManagedBean to
			// inject ejb's from data layer
public class TransportersResource {

	@EJB
	private TransporterEJB transporterEJB;

	// Get all transporters in db
	@GET
	public Collection<Transporter> getAllTransporters() {
		return transporterEJB.findAll();
	}

	// Get transporter by id - domain/api/v1/transporters/transporter/{id} - @param
	// id must be a number
	// (^[0-9]+$)
	@GET
	@Path("transporter/{id: ^[0-9]+$}")
	public Transporter getTransporterById(@PathParam("id") @DefaultValue("0") Long id) {
		return transporterEJB.find(id);
	}

	// Create new transporter
	@POST
	@Path("new")
	public void createTransporter(Transporter transporter) {
		transporterEJB.create(transporter);
	}

	// update the transporter info
	@PUT
	@Path("update")
	public void updateTransporter(Transporter transporter) {
		transporterEJB.edit(transporter);
	}

	// remove the transporter - @param id must be a number
	@DELETE
	@Path("delete/{id: ^[0-9]+$}")
	public void removeTransporter(@PathParam("id") @DefaultValue("0") Long id) {
		Transporter transporter = transporterEJB.find(id);

		if (transporter != null) {
			transporterEJB.remove(transporter);
		}
	}
}
