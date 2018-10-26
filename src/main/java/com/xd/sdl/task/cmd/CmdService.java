package com.xd.sdl.task.cmd;

import java.util.Scanner;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.logging.LogService;
import com.xd.sdl.logging.Logger;

/**
 * @author duanxiang
 * @since 2018/10/9 16:34
 */
public class CmdService extends Thread{

    private Logger logger = LogService.getLogger();
     private final Configuration configuration;

    public CmdService(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void run() {
        logger.debug("start cmd Service...");
        print("请输入命令:");
        Scanner scanner = new Scanner(System.in);
        RouteCommand routeCommand = new RouteCommand(configuration);
        while (scanner.hasNext()){
            String in = scanner.nextLine();
            routeCommand.cmd(in);
        }


    }

    void print(String msg){
        System.out.println(msg);
    }
}
