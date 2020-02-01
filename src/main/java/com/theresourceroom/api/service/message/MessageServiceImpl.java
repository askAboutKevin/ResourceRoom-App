package com.theresourceroom.api.service.message;

import com.theresourceroom.api.dal.dao.MessageDAO;
import com.theresourceroom.api.models.Message;
import com.theresourceroom.api.util.Status;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    private MessageDAO messageDAO;

    public MessageServiceImpl(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public List<Message> getMessages(int recipientId, Date lastUpdated) {
        if(recipientId < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.messageDAO.getAllMessages(recipientId, lastUpdated);
    }

    @Override
    public Status sendMessage(String text, int senderId, int recipientId) {

        if(senderId < 1 || recipientId < 1) {
            return new Status(false);
        }

        Status status = new Status((this.messageDAO.createMessage(text, senderId, recipientId) == 1));

        return status;
    }

    @Override
    public Status readMessage(int recipientId, int senderId) {

        if (recipientId < 1) {
            return new Status(false);
        }

//        Status status = new Status((this.messageDAO.readMessage(readTime) > 1));
//
//        return status;
        return null;
    }

    @Override
    public Status deleteMessage(int messageId) {

        if(messageId < 1) {
            return new Status(false);
        }

        Status status = new Status((this.messageDAO.deleteMessage(messageId) == 1));

        return status;
    }
}
