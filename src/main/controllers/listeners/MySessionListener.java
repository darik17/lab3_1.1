package main.controllers.listeners;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Created by admin on 22.04.2017.a
 */
public class MySessionListener implements HttpSessionListener {
    private static final Logger LOGGER = Logger.getLogger(MySessionListener.class);


    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.debug("Session id = " + httpSessionEvent.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
