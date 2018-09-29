package com.xd.sdl.enums;

/**
 * @author duanxiang
 * @since 2018/9/15 11:28
 */
public enum  HandlerTypeEnum {
    /**
     * 阻塞IO 单线程
     */
    BIO_SINGLE_THREAD,
    /**
     * 阻塞IO 多线程
     */
    BIO_MULTI_THREAD,
    /**
     * NIO 单线程
     */
    NIO_SINGLE_THREAD,
    /**
     * NIO多线程
     */
    NIO_MULTI_THREAD;
}
