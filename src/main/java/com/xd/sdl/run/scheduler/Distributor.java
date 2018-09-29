package com.xd.sdl.run.scheduler;

import com.xd.sdl.enums.HandlerTypeEnum;
import com.xd.sdl.handler.Handler;
import com.xd.sdl.task.Task;

/**
 * @author duanxiang
 * @since 2018/9/14 22:45
 */
public interface Distributor {

    /**
     * 开始工作
     */
    void work();

    /**
     * 分发任务
     * @param task
     */
    void distribute(Task task);

    void registerHandler(HandlerTypeEnum handlerType,Handler handler);


    }
