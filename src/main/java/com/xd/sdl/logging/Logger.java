package com.xd.sdl.logging;

/**
 * @author duanxiang
 * @since 2018/9/29 14:16
 */
public interface Logger {


    void start();

    void stop();

    void debug(String msg);

    void info(String msg);

    void error(String msg);

}
