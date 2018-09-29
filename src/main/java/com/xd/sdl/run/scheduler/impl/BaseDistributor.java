package com.xd.sdl.run.scheduler.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.enums.HandlerTypeEnum;
import com.xd.sdl.handler.Handler;
import com.xd.sdl.run.scheduler.Distributor;
import com.xd.sdl.task.TaskHolder;

/**
 * @author duanxiang
 * @since 2018/9/14 23:21
 */
public abstract class BaseDistributor implements Distributor {

    private Map<HandlerTypeEnum,List<Handler>> typeHandlers = new HashMap<>();

    private TaskHolder taskHolder;

    public BaseDistributor(Configuration configuration) {
        this.taskHolder = configuration.getTaskHolder();
    }

    @Override
    public void work() {
        this.distribute(taskHolder.get());
    }

    @Override
    public void registerHandler(HandlerTypeEnum handlerType,Handler handler){
        List<Handler> handlerList = typeHandlers.get(handlerType);
        if(handlerList == null){
            List<Handler> handlers = new ArrayList<>();
            handlers.add(handler);
            typeHandlers.put(handlerType,handlers);
        }
        handlerList.add(handler);
    }
}
