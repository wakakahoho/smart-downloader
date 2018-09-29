package com.xd.sdl.task;

import com.xd.sdl.config.Configuration;

/**
 * @author duanxiang
 * @since 2018/9/15 11:24
 */
public class SimpleTaskHolder extends AbstractTaskHolder {

    public SimpleTaskHolder(Configuration configuration) {
        super(configuration);
    }

    @Override
    public Task get() {
        return null;
    }
}
