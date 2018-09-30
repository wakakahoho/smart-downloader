package com.xd.sdl.task.cmd;

/**
 * @author duanxiang
 * @since 2018/9/14 22:51
 */
public interface Command {

    /**
     *
     * @param cmd
     * @return   false 命令错误 true 继续向下执行
     */
    boolean cmd(String  cmd);
}
