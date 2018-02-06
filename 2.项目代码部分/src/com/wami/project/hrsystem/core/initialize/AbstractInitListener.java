package com.wami.project.hrsystem.core.initialize;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public abstract class AbstractInitListener extends ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0);
    @Override
    public void contextDestroyed(ServletContextEvent arg0);
}
