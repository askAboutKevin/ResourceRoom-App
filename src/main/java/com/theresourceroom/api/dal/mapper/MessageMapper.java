package com.theresourceroom.api.dal.mapper;

import com.theresourceroom.api.models.Message;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<Message> {

    @Override
    public Message map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Message(
                rs.getInt("id"),
                rs.getString("text"),
                rs.getInt("senderId"),
                rs.getInt("recipientId"),
                rs.getString("timestamp")
        );
    }
}
