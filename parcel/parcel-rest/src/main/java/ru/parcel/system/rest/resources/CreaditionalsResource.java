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

import ru.parcel.system.dao.CreaditinalsEJB;
import ru.parcel.system.entities.Creaditionals;

@Path("creaditionals") // ../api/v1/creaditionals
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Stateless // Mark the resource with ejb annotation @Stateless to make it ManagedBean to
			// inject ejb's from data layer
public class CreaditionalsResource {

	@EJB
	private CreaditinalsEJB creaditinalsEJB;

	// Get all creaditinals in db
	@GET
	public Collection<Creaditionals> getAllCreaditionals() {
		return creaditinalsEJB.findAll();
	}

	// Get creaditional by id - domain/api/v1/creaditinals/creaditinal/{id} - @param
	// id must be a number
	// (^[0-9]+$)
	@GET
	@Path("creaditinal/{id: ^[0-9]+$}")
	public Creaditionals getCreaditionalById(@PathParam("id") @DefaultValue("0") Long id) {
		return creaditinalsEJB.find(id);
	}

	// Create new creaditinal
	@POST
	@Path("new")
	public void createCreaditional(Creaditionals creaditional) {
		creaditinalsEJB.create(creaditional);
	}

	// update the creaditional info
	@PUT
	@Path("update")
	public void updateCreaditional(Creaditionals creaditional) {
		creaditinalsEJB.edit(creaditional);
	}

	// remove the creaditional - @param id must be a number
	@DELETE
	@Path("delete/{id: ^[0-9]+$}")
	public void removeCreaditional(@PathParam("id") @DefaultValue("0") Long id) {
		Creaditionals creaditional = creaditinalsEJB.find(id);

		if (creaditional != null) {
			creaditinalsEJB.remove(creaditional);
		}
	}

}
