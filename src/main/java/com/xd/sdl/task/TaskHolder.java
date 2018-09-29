package com.xd.sdl.task;

import java.util.List;

/**
 * 实现获取任务
 *
 * @author duanxiang
 * @since 2018/9/15 11:22
 */
public interface TaskHolder {

    Task get();

    void addNewTask(Task task);

    void removeTask(String name);

    void listAll();

    List<Task> getNewTasks();


}
