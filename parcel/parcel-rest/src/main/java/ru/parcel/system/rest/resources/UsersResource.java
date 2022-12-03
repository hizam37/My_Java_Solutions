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

import ru.parcel.system.dao.UserEJB;
import ru.parcel.system.entities.User;

@Path("users") // .../api/v1/users
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Stateless // Mark the resource with ejb annotation @Stateless to make it ManagedBean to
			// inject ejb's from data layer
public class UsersResource {

	@EJB
	private UserEJB userEJB;

	// Get all users in db
	@GET
	public Collection<User> getAllUsers() {
		return userEJB.findAll();
	}

	// Get user by id - domain/api/v1/users/user/{id} - @param id must be a number
	// (^[0-9]+$)
	@GET
	@Path("user/{id: ^[0-9]+$}")
	public User getUserById(@PathParam("id") @DefaultValue("0") Long id) {
		return userEJB.find(id);
	}

	// Create new user
	@POST
	@Path("new")
	public void createUser(User user) {
		userEJB.create(user);
	}

	// update the user info
	@PUT
	@Path("update")
	public void updateUser(User user) {
		userEJB.edit(user);
	}

	// remove the user - @param id must be a number
	@DELETE
	@Path("delete/{id: ^[0-9]+$}")
	public void removeUser(@PathParam("id") @DefaultValue("0") Long id) {
		User user = userEJB.find(id);

		if (user != null) {
			userEJB.remove(user);
		}
	}

}
