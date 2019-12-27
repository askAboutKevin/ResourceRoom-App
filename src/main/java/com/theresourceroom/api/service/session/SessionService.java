package com.theresourceroom.api.service.session;

import com.theresourceroom.api.models.Session;

import java.util.Date;

public interface SessionService {

    Session getSessionWithCookie(String cookie);

    int renewSession(String cookie);

    int createNewSession(int user_id, String cookie, Date start);
}
