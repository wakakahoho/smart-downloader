package com.xd.sdl.logging;

import java.io.IOException;

/**
 * @author duanxiang
 * @since 2018/9/29 15:35
 */
public interface Appender {

    void write(byte[] msg) throws IOException;

    void close() throws IOException;
}
