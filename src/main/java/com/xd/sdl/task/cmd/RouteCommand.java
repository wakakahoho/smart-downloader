package com.xd.sdl.task.cmd;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.xd.sdl.config.Configuration;

/**
 * @author duanxiang
 * @since 2018/9/15 11:49
 */
public class RouteCommand implements Command {

    private Configuration configuration;

    private Command delegate;


    public RouteCommand(Configuration configuration) {
        this.configuration = configuration;
        SimpleCommand simpleCommand = new SimpleCommand(configuration);
        AddTaskCommand addTaskCommand = new AddTaskCommand(configuration, simpleCommand);
        delegate = new ListTaskCommand(configuration, addTaskCommand);
    }

    @Override
    public boolean cmd(String cmd) {
        if (StringUtils.isEmpty(cmd)) {
            return false;
        }
        return delegate.cmd(cmd);
    }



}
