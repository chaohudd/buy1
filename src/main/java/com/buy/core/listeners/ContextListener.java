package com.buy.core.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author: zhengkai
 * @create: 2018-05-05
 * @desc: 上下文监听器
 **/
public class ContextListener implements ServletContextAttributeListener, ServletContextListener {
    private ServletContext context = null;

    public void attributeAdded(ServletContextAttributeEvent event) {
        log("attributeAdded('" + event.getName() + "', '" +
            event.getValue() + "')");
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        log("attributeRemoved('" + event.getName() + "', '" +
            event.getValue() + "')");
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        log("attributeReplaced('" + event.getName() + "', '" +
            event.getValue() + "')");
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log("自定义的ContextListener被加载了，执行了contextInitialized()");

        String myName = servletContextEvent.getServletContext().getInitParameter("myName");
        log("context-param中自定义的键值对myName=>" + myName);

        this.context = servletContextEvent.getServletContext();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log("contextDestroyed()");
        this.context = null;
    }

    private void log(String message) {

        if (context != null)
            context.log("ContextListener: " + message);
        else
            System.out.println("ContextListener: " + message);

    }
}
