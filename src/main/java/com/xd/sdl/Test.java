package com.xd.sdl;

import com.xd.sdl.logging.LogService;

/**
 * @author duanxiang
 * @since 2018/9/15 12:09
 */
public class Test {

    /**
     * 命令行参数
     * 路径:文件里面的下载内容
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        LogService logService = new LogService();
        logService.start();
         while (true){
             Thread.sleep(1000);
             logService.info("222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333222223333333333333333333");
         }

    }

}
