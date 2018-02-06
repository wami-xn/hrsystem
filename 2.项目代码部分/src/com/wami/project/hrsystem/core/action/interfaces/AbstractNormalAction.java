package com.wami.project.hrsystem.core.action.interfaces;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

public interface AbstractNormalAction<T> extends AbstractAction<T>, ServletResponseAware, ServletRequestAware, ServletContextAware {
}
