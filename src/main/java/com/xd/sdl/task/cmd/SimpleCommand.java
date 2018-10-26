package com.xd.sdl.task.cmd;

import java.util.Objects;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.logging.LogService;
import com.xd.sdl.logging.Logger;
import com.xd.sdl.parser.UrlParser;
import com.xd.sdl.resource.Resource;

/**
 * @author duanxiang
 * @since 2018/9/14 22:55
 */
public class SimpleCommand extends AbstractCommand {

    private static final Logger logger = LogService.getLogger();

    public SimpleCommand(Configuration configuration) {
        super(configuration);
    }

    @Override
    public boolean cmd(String  cmd) {
        for(UrlParser parser : this.parserList){
            logger.info("正在解析...");
            Resource resource = parser.parse(cmd);
            if(Objects.nonNull(resource)){
                this.resourceHolder.addResource(resource);
                return true;
            }

        }
        return false;
    }
}
