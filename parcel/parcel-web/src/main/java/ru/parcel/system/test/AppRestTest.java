package ru.parcel.system.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class AppRestTest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return "Hello World";
	}
}
