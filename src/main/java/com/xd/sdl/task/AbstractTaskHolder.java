package com.xd.sdl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.xd.sdl.config.Configuration;

/**
 * @author duanxiang
 * @since 2018/9/15 11:11
 */
public abstract class AbstractTaskHolder implements TaskHolder {

    private Configuration configuration;

    public AbstractTaskHolder(Configuration configuration) {
        this.configuration = configuration;
    }

    private BlockingQueue<Task> newTasks = new ArrayBlockingQueue<>(20);

//    private List<Task> finishedTasks = new ArrayList<>();
//
//    private List<Task> errorTasks = new ArrayList<>();

    @Override
    public void addNewTask(Task task) {
        newTasks.add(task);
    }




}
