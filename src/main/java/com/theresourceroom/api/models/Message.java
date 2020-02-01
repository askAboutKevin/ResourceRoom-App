package com.theresourceroom.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Message {

    private int id;
    private String text;
    private int senderId;
    private int recipientId;
    private String timestamp;


    public Message(int id, String text, int senderId, int recipientId, String timestamp) {
        this.id = id;
        this.text = text;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.timestamp = timestamp;
    }

    @JsonCreator
    public Message(@JsonProperty("text") String text, @JsonProperty("senderId") int senderId, @JsonProperty("recipientId") int recipientId ) {
        this.text = text;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ColumnName("senderId")
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @ColumnName("recipientId")
    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    @ColumnName("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
