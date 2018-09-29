package com.xd.sdl.resource;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resources;

import com.xd.sdl.config.Configuration;

/**
 * @author duanxiang
 * @since 2018/9/14 23:47
 */
public class ResourceHolder {

    private Configuration configuration;

    private final List<Resource> resources = new ArrayList<>();


    public ResourceHolder(Configuration configuration){
        this.configuration = configuration;
    }

    public void addResource(Resource resource){
        resources.add(resource);
        //通知打包器进行打包
        configuration.packager().packaging(resource);
    }
    public Configuration getConfiguration() {
        return configuration;
    }


}
