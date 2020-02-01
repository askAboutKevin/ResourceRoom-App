package com.theresourceroom.api.resource;

import com.theresourceroom.api.models.Message;
import com.theresourceroom.api.models.User;
import com.theresourceroom.api.service.message.MessageService;
import com.theresourceroom.api.util.Status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService;

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    public Response getMessages(@QueryParam("currentTime") Date currentTime, User user) {

        List<Message> messages = this.messageService.getMessages(user.getId(), currentTime);

        if(messages != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(messages)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @POST
    public Response sendMessage(Message message) {

        Status status = this.messageService.sendMessage(
                message.getText(),
                message.getSenderId(),
                message.getRecipientId()
        );

        if(status != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(status)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @DELETE
    public Response deleteMessage(int messageId) {
        Status status = this.messageService.deleteMessage(messageId);

        if(status != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(status)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @PUT
    public Response sendReadReceipt(Message message) {

        Status status = this.messageService.readMessage(message.getRecipientId(), message.getSenderId());

        if(status != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(status)
                    .build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    };


}
