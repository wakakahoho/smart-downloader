package com.xd.sdl.logging;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



/**
 * @author duanxiang
 * @since 2018/9/29 14:20
 */
public class LogService implements Logger {

    private static final String NAME = LogService.class.getName();
    private static final int MAX_RETRY_TIMES = 3;
    private BlockingQueue<String> logs;
    private LogThread thread;
    private volatile boolean start = false;
    private LogLevel defaultLevel = LogLevel.INFO;
    private int retryTimes = 0;

    private LogService() {
        this.logs = new ArrayBlockingQueue<>(1024);
        this.thread = new LogThread(NAME, logs);
        start();
    }


    @Override
    public void start() {
            if (start) {
                throw new IllegalStateException("LogService already started!");
            }
            thread.start();
            start = true;
    }

    @Override
    public void stop() {
        if (!start) {
            throw new IllegalStateException("LogService is not started!");
        }
        thread.cancel();
        start = false;


    }

    @Override
    public void debug(String msg) {
        if (!LogLevel.ERROR.equals(defaultLevel)) {
            log("DEBUG->" + getTimeStamp() + ":" + msg);
        }
    }

    @Override
    public void info(String msg) {
            log("INFO->" + getTimeStamp() + ":" + msg);
    }

    @Override
    public void error(String msg) {
        if (LogLevel.ERROR.equals(defaultLevel)) {
            log("ERROR->" + getTimeStamp() + ":" + msg);
        }
    }

    private void log(String msg) {
        try {

            synchronized (this) {
                if (this.thread.isStop()) {
                    this.retryTimes++;
                    if (retryTimes > MAX_RETRY_TIMES) {
                        throw new RuntimeException(
                            "LogService got a error! LogService attempt restart failure");
                    }
                    //restart
                    stop();
                    this.thread = new LogThread(NAME,logs);
                    start();
                    System.out.println("restarting...");


                }

            }

            msg = getContext() + ":" + msg;
            msg += "\n";
            logs.put(msg);

        } catch (InterruptedException e) {
            //stop logger Thread
            this.stop();
            Thread.currentThread().interrupt();
        }
    }

    private String getContext() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement log = stackTrace[1];
        String tag = null;
        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement e = stackTrace[i];
            if (!e.getClassName().equals(log.getClassName())) {
                tag = e.getClassName() + "." + e.getMethodName();
                break;
            }
        }
        if (tag == null) {
            tag = log.getClassName() + "." + log.getMethodName();

        }
        return tag;
    }


    public void setLevel(LogLevel level) {
        this.defaultLevel = level;
    }

    public static Logger getLogger() {
        return LoggerHolder.logService;
    }


    private String getTimeStamp() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);

    }

    private static class LoggerHolder {

        public static LogService logService = new LogService();
    }


    enum LogLevel {

        DEBUG("debug"),
        INFO("info"),
        ERROR("error");

        private String value;

        LogLevel(String value) {
            this.value = value;
        }
    }

}
