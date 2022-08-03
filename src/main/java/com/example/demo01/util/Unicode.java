package com.example.demo01.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @param string
 * @Title: unicodeDecode
 * @Description: unicode解码
 * @return
 */
public class Unicode {

    public static String unicodeDecode(String string) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(string);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            string = string.replace(matcher.group(1), ch + "");
        }
        return string;
    }

    public static void main(String[] args) {
        unicodeDecode("\"\\u5F00\",\"cmode\"");
        System.out.println("编码后："+unicodeDecode("\"\\u5F00\",\"cmode\""));
    }
}
