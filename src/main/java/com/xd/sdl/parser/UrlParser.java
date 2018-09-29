package com.xd.sdl.parser;

import com.xd.sdl.connection.Connection;
import com.xd.sdl.resource.Resource;

/**
 * @author duanxiang
 * @since 2018/9/14 19:33
 */
public interface UrlParser {

    /**
     * 解析任务列表
     * @param url
     * @return
     */
    Resource parse(String url);
}
