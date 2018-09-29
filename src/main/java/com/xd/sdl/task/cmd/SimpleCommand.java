package com.xd.sdl.task.cmd;

import java.util.Objects;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.parser.UrlParser;
import com.xd.sdl.resource.Resource;

/**
 * @author duanxiang
 * @since 2018/9/14 22:55
 */
public class SimpleCommand extends AbstractCommand {

    public SimpleCommand(Configuration configuration) {
        super(configuration);
    }

    @Override
    public boolean cmd(String  cmd) {
        for(UrlParser parser : this.parserList){
            System.out.println(cmd);
            Resource resource = parser.parse(cmd);
            if(Objects.nonNull(resource)){
                this.resourceHolder.addResource(resource);
                return true;
            }

        }
        return false;
    }
}
