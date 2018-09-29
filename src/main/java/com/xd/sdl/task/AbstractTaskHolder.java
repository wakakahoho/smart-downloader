package com.xd.sdl.task;

import java.util.ArrayList;
import java.util.List;

import com.xd.sdl.config.Configuration;

/**
 * @author duanxiang
 * @since 2018/9/15 11:11
 */
public  abstract  class AbstractTaskHolder implements  TaskHolder{

    private Configuration configuration ;

    public AbstractTaskHolder(Configuration configuration){
        this.configuration = configuration;
    }
    private List<Task> newTasks = new ArrayList<>();

    private List<Task> finishedTasks = new ArrayList<>();

    private List<Task> errorTasks = new ArrayList<>();

    public void addNewTask(Task task){
        newTasks.add(task);
    }

    public void removeTask(String name){

    }
    public void listAll(){

    }
    public List<Task> getNewTasks (){
        return  newTasks;
    }



}
