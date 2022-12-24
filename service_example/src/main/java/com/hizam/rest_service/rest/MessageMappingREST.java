package com.hizam.rest_service.rest;
import com.hizam.rest_service.entity.MessageMapping;
import com.hizam.rest_service.registrator.MessageMappingRegistrator;
import com.hizam.rest_service.repository.MessageMappingRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;



@RequestScoped
@Path("/message_mapping")
public class MessageMappingREST {
    @Inject
    private Logger logger;

    @Inject
    private MessageMappingRegistrator registrator;

    @Inject
    private MessageMappingRepository repository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll(){
        logger.info("Get full message mapping");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getmappingById(@PathParam("id") long id){
        logger.info("Get mapping by Id: " + id );
        return repository.getById(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public MessageMapping createMapping(MessageMapping item) {
        return registrator.create(item);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public MessageMapping updateMapping(MessageMapping item)
    {
      return   registrator.update(item);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public MessageMapping deleteMappingById(@PathParam("id") long id){
       return registrator.delete(id);
    }
}
