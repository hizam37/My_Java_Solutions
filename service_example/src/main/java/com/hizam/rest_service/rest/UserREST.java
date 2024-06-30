package com.hizam.rest_service.rest;
import com.hizam.rest_service.entity.User;
import com.hizam.rest_service.registrator.UserRegistrator;
import com.hizam.rest_service.repository.UserRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;


@RequestScoped
@Path("/user")
public class UserREST {

    @Inject
    private Logger logger;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserRegistrator userRegistrator;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){

        return userRepository.getAll();
    }



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id){
        return  userRepository.getById(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public User createuser(User item) {
     return userRegistrator.create(item);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public User updateuser(User item) {
        return userRegistrator.update(item);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
        public User deleteUserById(@PathParam("id") long id){

        return userRegistrator.delete(id);
    }
}
