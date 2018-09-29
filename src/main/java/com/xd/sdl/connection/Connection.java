package com.xd.sdl.connection;

import java.io.IOException;


/**
 * @author duanxiang
 * @since 2018/9/14 19:41
 */
public interface Connection {

    void  connect() throws IOException;

    int length();

    String filename();

    void close();
}
