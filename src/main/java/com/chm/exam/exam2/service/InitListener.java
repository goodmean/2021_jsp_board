package com.chm.exam.exam2.service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.chm.exam.exam2.dto.App;

@WebListener
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("On start web app");
        App.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("On shutdown web app");
    }

}