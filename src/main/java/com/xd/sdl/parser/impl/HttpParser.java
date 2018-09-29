package com.xd.sdl.parser.impl;

import java.net.HttpURLConnection;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import com.xd.sdl.connection.Connection;
import com.xd.sdl.connection.http.HttpConnection;
import com.xd.sdl.parser.UrlParser;
import com.xd.sdl.resource.HttpResource;
import com.xd.sdl.resource.Resource;

/**
 * @author duanxiang
 * @since 2018/9/14 19:35
 */
public class HttpParser extends BaseUrlParser {

    private static final String HTTP_PREFIX ="http://";

    @Override
    public Resource parse(String url) {
        if(url.startsWith(HTTP_PREFIX)){
            Resource resource = new HttpResource();
            resource.setId(System.currentTimeMillis());
            resource.setUrl(url);
            return resource;
        }
        return null;
    }
}
