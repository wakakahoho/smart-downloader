package com.xd.sdl.parser;

/**
 * @author duanxiang
 * @since 2018/9/15 12:45
 */
public class ParseUtil {

    public static String cut(String cmd, String source) {
        return source.replace(cmd,"").trim();
    }

    public static void main(String[] args) {
        System.out.println(cut("add","add 1"));
    }
}
