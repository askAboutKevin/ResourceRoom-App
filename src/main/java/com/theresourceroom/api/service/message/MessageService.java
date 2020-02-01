package com.theresourceroom.api.service.message;

import com.theresourceroom.api.models.Message;
import com.theresourceroom.api.util.Status;

import java.util.Date;
import java.util.List;

public interface MessageService {

    List<Message> getMessages(int recipientId, Date lastUpdated);

    Status sendMessage(String text, int senderId, int recipientId);

    Status readMessage(int recipientId, int senderId);

    Status deleteMessage(int messageId);
}
