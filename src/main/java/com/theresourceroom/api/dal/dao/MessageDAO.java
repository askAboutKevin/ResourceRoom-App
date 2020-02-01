package com.theresourceroom.api.dal.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.theresourceroom.api.dal.mapper.MessageMapper;
import com.theresourceroom.api.models.Message;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Date;
import java.util.List;

public interface MessageDAO {

    @SqlQuery("SELECT id, text, senderId, recipientId, timestamp FROM Message WHERE recipientId = ? AND timestamp < ?")
    @RegisterRowMapper(MessageMapper.class)
    List<Message> getAllMessages(int recipientId, Date lastUpdated);

    @SqlUpdate("INSERT INTO Message (text, senderId, recipientId) VALUES (?, ?, ?)")
    int createMessage(String text, int senderId, int recipientId);

    @SqlUpdate("DELETE FROM Message WHERE id = ?")
    int deleteMessage(int messageId);

}
