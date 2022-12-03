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

import ru.parcel.system.dao.ParcelEJB;
import ru.parcel.system.entities.Parcel;

@Path("parcels") // ../api/v1/parcels
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Stateless // Mark the resource with ejb annotation @Stateless to make it ManagedBean to
			// inject ejb's from data layer
public class ParcelResource {

	@EJB
	private ParcelEJB parcelEJB;

	// Get all parcels in db
	@GET
	public Collection<Parcel> getAllParcels() {
		return parcelEJB.findAll();
	}

	// Get parcels by id - domain/api/v1/parcels/parcel/{id} - @param
	// id must be a number
	// (^[0-9]+$)
	@GET
	@Path("parcel/{id: ^[0-9]+$}")
	public Parcel getParcelById(@PathParam("id") @DefaultValue("0") Long id) {
		return parcelEJB.find(id);
	}

	// Create new parcel
	@POST
	@Path("new")
	public void createParcel(Parcel parcel) {
		parcelEJB.create(parcel);
	}

	// update the parcel info
	@PUT
	@Path("update")
	public void updateParcel(Parcel parcel) {
		parcelEJB.edit(parcel);
	}

	// remove the parcel - @param id must be a number
	@DELETE
	@Path("delete/{id: ^[0-9]+$}")
	public void removeParcel(@PathParam("id") @DefaultValue("0") Long id) {
		Parcel parcel = parcelEJB.find(id);

		if (parcel != null) {
			parcelEJB.remove(parcel);
		}
	}

}
