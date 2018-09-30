package com.xd.sdl.run;

import java.util.Scanner;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.logging.LogService;
import com.xd.sdl.logging.Logger;
import com.xd.sdl.task.cmd.RouteCommand;


/**
 * 服务启动类
 *
 * @author duanxiang
 * @since 2018/9/14 22:41
 */
public class SdlDownloaderBootStrapper {

    private Configuration configuration = new Configuration();
    private static final Logger logger = LogService.getLogger();
    public static void main(String[] args) throws InterruptedException {
       while (true){
           Thread.sleep(1000);
           logger.info("启动下载服务");

       }

    }
}
