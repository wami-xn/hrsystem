package com.wami.project.hrsystem.core.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

public class LocalSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("loginTime", new Date());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
