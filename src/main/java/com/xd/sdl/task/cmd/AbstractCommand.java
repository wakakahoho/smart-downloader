package com.xd.sdl.task.cmd;

import java.util.List;

import com.xd.sdl.config.Configuration;
import com.xd.sdl.handler.Handler;
import com.xd.sdl.parser.UrlParser;
import com.xd.sdl.resource.Resource;
import com.xd.sdl.resource.ResourceHolder;

/**
 * @author duanxiang
 * @since 2018/9/15 11:50
 */
public abstract class AbstractCommand implements Command {

    private Configuration configuration;

    protected List<UrlParser> parserList;

    protected ResourceHolder resourceHolder;

    public AbstractCommand(Configuration configuration) {
        this.configuration = configuration;
        parserList = configuration.getParserChain();
        resourceHolder = configuration.getResourceHolder();
    }

}
