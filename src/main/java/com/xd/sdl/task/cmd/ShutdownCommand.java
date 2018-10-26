package com.xd.sdl.task.cmd;

import com.xd.sdl.config.Configuration;

/**
 * 关闭服务， 保存任务进度
 * @author duanxiang
 * @since 2018/10/9 17:24
 */
public class ShutdownCommand extends AbstractCommand {

    public ShutdownCommand(Configuration configuration) {
        super(configuration);
    }

    @Override
    public boolean cmd(String cmd) {
        return false;
    }
}
