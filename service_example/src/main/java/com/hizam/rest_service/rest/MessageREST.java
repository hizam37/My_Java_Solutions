package com.hizam.rest_service.rest;
import com.hizam.rest_service.entity.Message;
import com.hizam.rest_service.registrator.MessageRegistrator;
import com.hizam.rest_service.repository.MessageRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;


@RequestScoped
@Path("/message")
public class MessageREST {

    @Inject
    private Logger logger;

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private MessageRegistrator messageRegistrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getListAll(){
        logger.info("Get all messages");
        return messageRepository.getAll();
    }



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageById(@PathParam("id") long id)
    {
        return  messageRepository.getById(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Message createMessage(Message item) {
        return messageRegistrator.create(item);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Message updateMessage(Message item) {
        return messageRegistrator.update(item);
    }

    @DELETE
    @Path("delete/{id}")
    public Message deleteMessageById(@PathParam("id") long id){

        return messageRegistrator.delete(id);
    }
}


