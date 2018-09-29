package com.xd.sdl.handler;

import com.xd.sdl.task.Task;

/**
 * 处理下载任务
 * @author duanxiang
 * @since 2018/9/14 22:43
 */
public interface Handler {

    public boolean handle(Task task);
}
