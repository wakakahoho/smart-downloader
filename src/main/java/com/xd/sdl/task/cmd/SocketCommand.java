package com.xd.sdl.task.cmd;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import com.xd.sdl.logging.LogService;
import com.xd.sdl.logging.Logger;

/**
 * @author duanxiang
 * @since 2018/9/30 09:46
 */
public class SocketCommand  implements Command{

    private final Logger log = LogService.getLogger();

    private final RouteCommand delegate;

    public SocketCommand(RouteCommand delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean cmd(String cmd) {
        log.info("打开服务器");
        try( ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(44));
            serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
