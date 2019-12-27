package com.theresourceroom.api.service.session;

import com.theresourceroom.api.dal.dao.SessionDAO;
import com.theresourceroom.api.models.Session;

import java.util.Date;

public class SessionServiceWebImpl implements SessionService {

    private SessionDAO sessionDAO;

    public SessionServiceWebImpl(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    @Override
    public Session getSessionWithCookie(String cookie) {
        return sessionDAO.getSessionWithCookie(cookie);
    }

    @Override
    public int renewSession(String cookie) {
        return sessionDAO.renewSession(cookie);
    }

    @Override
    public int createNewSession(int user_id, String cookie, Date start) {
        return sessionDAO.createNewSession(user_id, cookie, start);
    }
}
