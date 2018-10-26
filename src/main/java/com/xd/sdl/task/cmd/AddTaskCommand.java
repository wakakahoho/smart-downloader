package com.xd.sdl.task.cmd;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.logging.LogService;
import com.xd.sdl.logging.Logger;
import com.xd.sdl.parser.ParseUtil;
import com.xd.sdl.task.TaskHolder;

/**
 * @author duanxiang
 * @since 2018/9/15 12:00
 */
public class AddTaskCommand extends AbstractCommand {
    private static final Logger logger = LogService.getLogger();
    private  final String ADD_CMD = "add";
    private Command delegate;
    private TaskHolder taskHolder ;
    public AddTaskCommand(Configuration configuration,Command delegate) {
        super(configuration);
        this.delegate = delegate;
        this.taskHolder = configuration.getTaskHolder();
    }
    @Override
    public boolean cmd(String cmd) {
        if(cmd.startsWith(ADD_CMD)){
            logger.info("recv add command");
            return delegate.cmd(ParseUtil.cut(ADD_CMD,cmd));
        }
        return delegate.cmd(cmd);
    }
}
