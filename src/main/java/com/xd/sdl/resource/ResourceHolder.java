package com.xd.sdl.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resources;

import com.xd.sdl.config.Configuration;

/**
 * @author duanxiang
 * @since 2018/9/14 23:47
 */
public class ResourceHolder {

    private Configuration configuration;

    private final BlockingQueue<Resource> resources = new ArrayBlockingQueue<>(20);

    public ResourceHolder(Configuration configuration){
        this.configuration = configuration;
    }

    public void addResource(Resource resource){
        resources.add(resource);
    }

    public BlockingQueue<Resource> getResources() {
        return resources;
    }

    public Configuration getConfiguration() {
        return configuration;
    }


}
