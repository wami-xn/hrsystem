package com.wami.project.hrsystem.core.initialize;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public abstract class AbstractThread extends AbstractInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // Tomcat启动结束后执行
        // 子线程需要做的事情
        new Thread(this::execute).start();
    }
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }
    protected void execute(){

    }
}
