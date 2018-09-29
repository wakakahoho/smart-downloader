package com.xd.sdl.connection.http;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.xd.sdl.connection.Connection;
import com.xd.sdl.resource.Resource;

/**
 * @author duanxiang
 * @since 2018/9/14 19:43
 */
public class HttpConnection implements Connection {

    private HttpURLConnection httpURLConnection;

    public HttpConnection(Resource resource) {
        try {
            URL ul = new URL(resource.getUrl());
            this.httpURLConnection = (HttpURLConnection) ul.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect() throws IOException {
        httpURLConnection.connect();
    }

    @Override
    public int length() {
        return httpURLConnection.getContentLength();
    }

    @Override
    public String filename() {
        String filePathUrl = httpURLConnection.getURL().getFile();
        String fileFullName = filePathUrl
            .substring(filePathUrl.lastIndexOf(File.separatorChar) + 1);
        return fileFullName;
    }

    @Override
    public void close() {
        httpURLConnection.disconnect();
    }
}
