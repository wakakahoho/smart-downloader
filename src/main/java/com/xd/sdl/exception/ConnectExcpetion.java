package com.xd.sdl.exception;

import java.io.IOException;

/**
 * @author duanxiang
 * @since 2018/9/15 20:37
 */
public class ConnectExcpetion extends IOException {

    public ConnectExcpetion(String message) {
        super(message);
    }
}
