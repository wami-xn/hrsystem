package com.wami.project.hrsystem.core.initialize;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public abstract class AbstractInitListener implements ServletContextListener {
    @Override
    public abstract void contextInitialized(ServletContextEvent arg0);
    @Override
    public abstract void contextDestroyed(ServletContextEvent arg0);
}
