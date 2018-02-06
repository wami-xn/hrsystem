package com.wami.project.hrsystem.core.initialize;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public abstract class AbstractSingletonInitListener extends AbstractInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // Tomcat启动结束后执行
        // 子线程需要做的事情
        new Thread(this::newInstance).start();
    }
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }
    protected void newInstance(){

    }
}
