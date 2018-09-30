package com.xd.sdl.logging;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.BlockingQueue;

import com.xd.sdl.logging.appender.Appender;
import com.xd.sdl.logging.appender.impl.LocalFileSystemAppender;

/**
 * @author duanxiang
 * @since 2018/9/30 16:36
 */
public class LogThread extends Thread{
    /**
     * 1 seconds write once
     */
    private static final long INTERVAL = 500;

    private final BlockingQueue<String> queue;
    private final Appender appender;
    private long lastTimeStamp = 0L;
    private volatile boolean stop = false;


    LogThread(String name, BlockingQueue<String> queue) {
        super(name);
        this.queue = queue;
        this.appender = new LocalFileSystemAppender();

    }

    @Override
    public void interrupt() {
        try {
            appender.close();
        } catch (IOException e) {
            //do nothing
        } finally {

            super.interrupt();
        }

    }

    public boolean isStop() {
        return stop;
    }

    public void cancel(){
        interrupt();
        stop = true;
    }

    @Override
    public void run() {
        try {
            this.appender.init();
            while (!isInterrupted()&& !stop) {
                if (0 == lastTimeStamp
                    || Instant.now().toEpochMilli() - lastTimeStamp > INTERVAL
                    || queue.size() > 20) {
                    appender.write(queue.take().getBytes());
                    lastTimeStamp = Instant.now().toEpochMilli();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            cancel();
        }
    }
}
