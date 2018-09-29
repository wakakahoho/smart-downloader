package com.xd.sdl.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.xd.sdl.connection.Connection;
import com.xd.sdl.connection.ConnectionFactory;
import com.xd.sdl.connection.http.HttpConnection;
import com.xd.sdl.handler.Handler;
import com.xd.sdl.handler.impl.SimpleHandler;
import com.xd.sdl.parser.UrlParser;
import com.xd.sdl.parser.impl.HttpParser;
import com.xd.sdl.resource.HttpResource;
import com.xd.sdl.resource.Resource;
import com.xd.sdl.resource.ResourceHolder;
import com.xd.sdl.run.packager.Packager;
import com.xd.sdl.run.packager.impl.SimplePackager;
import com.xd.sdl.run.scheduler.Distributor;
import com.xd.sdl.run.scheduler.impl.SimpleDistributor;
import com.xd.sdl.task.SimpleTaskHolder;
import com.xd.sdl.task.TaskHolder;
import com.xd.sdl.task.cmd.Command;
import com.xd.sdl.task.cmd.RouteCommand;

/**
 * @author duanxiang
 * @since 2018/9/14 19:44
 */
public class Configuration {

    private int defualtTimeout ;
    /**
     * 单线程BIO
     */
    private int defualtMode = 1;


    private TaskHolder taskHolder = new SimpleTaskHolder(this);

    private Distributor distributor = new SimpleDistributor(this);

    private List<UrlParser> parserChain = new ArrayList<>();

    private ResourceHolder resourceHolder = new ResourceHolder(this);

    private Packager packager = new SimplePackager(resourceHolder,distributor);

    private Map<Class<? extends Resource>, Class<? extends Connection>> resourceConnectionMapinng = new HashMap<>();

    private Map<Class<? extends Connection>, Class<? extends  Handler>>  connectionHandlerMapping = new HashMap<>();

    private ConnectionFactory connectionFactory = new ConnectionFactory(this);

    public void addUrlParser(UrlParser parser){
        this.parserChain.add(parser);
    }

    public TaskHolder getTaskHolder(){
        return taskHolder;
    }

    public List<UrlParser> getParserChain (){
        return parserChain;
    }

    public ResourceHolder getResourceHolder(){
        return resourceHolder;
    }

    public Packager packager(){
        return packager;
    }

    {
        addUrlParser(new HttpParser());
        resourceConnectionMapinng.put(HttpResource.class,HttpConnection.class);


    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public Map<Class<? extends Resource>, Class<? extends Connection>> getResourceConnectionMapinng() {
        return resourceConnectionMapinng;
    }


}
