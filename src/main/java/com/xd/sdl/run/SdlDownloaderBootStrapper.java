package com.xd.sdl.run;

import java.util.Scanner;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.task.cmd.RouteCommand;


/**
 * 服务启动类
 *
 * @author duanxiang
 * @since 2018/9/14 22:41
 */
public class SdlDownloaderBootStrapper {

    private Configuration configuration = new Configuration();
    RouteCommand command = new RouteCommand(configuration);

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String cmdString = scan.nextLine();
            if ("stop".equals(cmdString)) {
                break;
            }
            if (!command.cmd(cmdString)) {
                System.out.println("下载任务出错");
            }
        }

    }
}
