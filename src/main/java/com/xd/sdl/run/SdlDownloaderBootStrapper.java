package com.xd.sdl.run;


import com.xd.sdl.config.Configuration;
import com.xd.sdl.logging.LogService;
import com.xd.sdl.logging.Logger;
import com.xd.sdl.task.cmd.CmdService;


/**
 * 服务启动类
 *
 * @author duanxiang
 * @since 2018/9/14 22:41
 */
public class SdlDownloaderBootStrapper {

    private static Configuration configuration = new Configuration();
    private static final Logger logger = LogService.getLogger();
    private static CmdService cmdService = new CmdService(configuration);
    public static void main(String[] args) throws InterruptedException {
        logger.info("start SdlDownloaderBootStrapper");
        cmdService.start();

    }
}
