package com.xd.sdl.run.packager.impl;

import java.io.IOException;

import com.xd.sdl.connection.Connection;
import com.xd.sdl.connection.ConnectionFactory;
import com.xd.sdl.exception.ConnectExcpetion;
import com.xd.sdl.resource.Resource;
import com.xd.sdl.resource.ResourceHolder;
import com.xd.sdl.run.packager.Packager;
import com.xd.sdl.run.scheduler.Distributor;
import com.xd.sdl.task.Task;
import com.xd.sdl.task.impl.SimpleTask;

/**
 * @author duanxiang
 * @since 2018/9/15 11:02
 */
public class SimplePackager implements Packager,Runnable {



    private ResourceHolder resourceHolder;

    private Distributor distributor;

    private ConnectionFactory connectionFactory;

    public SimplePackager(ResourceHolder resourceHolder, Distributor distributor) {
        this.resourceHolder = resourceHolder;
        this.distributor = distributor;
        this.connectionFactory = resourceHolder.getConfiguration().getConnectionFactory();
    }

    @Override
    public void packaging(Resource resource) {

        System.out.println(resource.toString());
        System.out.println("正在获取文件资源大小.....");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection(resource);
        } catch (ConnectExcpetion connectExcpetion) {
            connectExcpetion.printStackTrace();
        }
        try {
            connection.connect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Task task = new SimpleTask();
        task.setResourceId(resource.getId());
        task.setName(connection.filename());
        task.setId(System.currentTimeMillis());
        task.setSize(connection.length());
        task.setStorePath("/devlp");
        resourceHolder.getConfiguration().getTaskHolder().addNewTask(task);

    }


    @Override
    public void run() {

    }
}
