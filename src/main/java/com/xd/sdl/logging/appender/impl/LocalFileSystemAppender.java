package com.xd.sdl.logging.appender.impl;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.xd.sdl.logging.appender.Appender;

/**
 * @author duanxiang
 * @since 2018/9/29 15:36
 */
public class LocalFileSystemAppender implements Appender {

    /**
     * 每次读取字节数
     */
    private static final int READ_SIZE = 1024;

    private final String logPath = "/devlp/log2.out";
    private final boolean isDelete = false;
    private FileChannel fileChannel;

    private ByteBuffer byteBuffer;
    private Path path;

    public LocalFileSystemAppender() {

    }

    @Override
    public void init() throws IOException {
        File file = new File(logPath);
        if (!file.exists()) {
            file.createNewFile();
        }
        path = Paths.get(logPath);
        fileChannel = FileChannel.open(path, StandardOpenOption.APPEND);
        byteBuffer = ByteBuffer.allocate(READ_SIZE);


    }

    @Override
    public void write(byte[] msg) throws IOException {
        if (!fileChannel.isOpen()) {
            throw new IllegalStateException("LocalFileSystemAppender closed");
        }
        int count = msg.length / READ_SIZE;
        int left = msg.length % READ_SIZE;
        if (left > 0) {
            count++;
        }

        for (int i = 0; i < count; i++) {
            if (count == 1 || i == count - 1) {
                byteBuffer.put(msg, i * READ_SIZE, left);
            } else {
                byteBuffer.put(msg, i * READ_SIZE, READ_SIZE);

            }

        }
        commit();


    }

    @Override
    public void close() throws IOException {
        synchronized (this) {
            this.fileChannel.close();
            if (isDelete) {
                path = Paths.get(logPath);
                Files.delete(path);
            }
        }


    }

    private void commit() throws IOException {
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        byteBuffer.flip();
        byteBuffer.clear();
    }
}
