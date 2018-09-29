package com.xd.sdl.task.cmd;

import java.util.List;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.parser.ParseUtil;
import com.xd.sdl.task.Task;
import com.xd.sdl.task.TaskHolder;

/**
 * 展示任务列表命令处理
 * @author duanxiang
 * @since 2018/9/15 12:00
 */
public class ListTaskCommand extends AbstractCommand {

    private final String LIST_CMD = "ls";
    private final String LIST_NEW = "ls -new";
    private TaskHolder taskHolder;

    private Command delegate;
    public ListTaskCommand(Configuration configuration,Command delegate) {
        super(configuration);
        this.taskHolder = configuration.getTaskHolder();
        this.delegate = delegate;
    }

    @Override
    public boolean cmd(String cmd) {
        if(LIST_NEW.equalsIgnoreCase(cmd)){
            List<Task> newTasks = taskHolder.getNewTasks();
            System.out.println(newTasks);
            return true;
        }
        return delegate.cmd(cmd);
    }
}
