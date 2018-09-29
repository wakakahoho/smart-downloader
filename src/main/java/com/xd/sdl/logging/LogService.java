package com.xd.sdl.logging;


import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author duanxiang
 * @since 2018/9/29 14:20
 */
public class LogService implements Logger {

    private static final String NAME = LogService.class.getName();
    private final Appender appender;
    private final BlockingQueue<String> logs;
    private final LogThread thread;



    public LogService() {
        appender = new LocalFileSystemAppender();
        logs = new LinkedBlockingQueue<>();
        thread = new LogThread(NAME, logs, appender);
    }

    @Override
    public void start() {
        thread.start();
        System.out.println("log service started");
    }

    @Override
    public void stop() {
        thread.interrupt();
        System.out.println("log service stoped");

    }

    @Override
    public void debug(String msg) {

        log("DEBUG->"+getTimeStamp()+":"+msg);
    }

    @Override
    public void info(String msg) {

        log("INFO->"+getTimeStamp()+":"+msg);

    }

    @Override
    public void error(String msg) {
        log("ERROR->"+getTimeStamp()+":"+msg);

    }

    private void log(String msg) {
        try {
            msg += "\n";
            logs.put(msg);
        } catch (InterruptedException e) {
            //stop logger Thread
            this.stop();
            Thread.currentThread().interrupt();
        }
    }

    class LogThread extends Thread {
        /**
         * 1 seconds write once
         */

        private static final long interval = 500;

        private final BlockingQueue<String> queue;
        private final Appender appender;
        private long lastTimeStamp = 0L;


        LogThread(String name, BlockingQueue<String> queue, Appender appender) {
            super(name);
            this.queue = queue;
            this.appender = appender;

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

        @Override
        public void run() {
            try {
                while (!isInterrupted()){
                    if(0 == lastTimeStamp || Instant.now().toEpochMilli() -lastTimeStamp > interval|| queue.size()> 20){
                        appender.write(queue.take().getBytes());
                        lastTimeStamp = Instant.now().toEpochMilli();
                    }
                }
            } catch (Exception e) {
                interrupt();
            }
        }
    }


    private String getTimeStamp() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = localDateTime.format(formatter);
        return format;

    }

}
