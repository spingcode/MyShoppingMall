package com.kaola.util;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 17:18 2018/2/23
 *@Modified By:
 */

import java.util.Properties;

public class PathSeparator {
    static final Properties PROPERTIES = new Properties(System.getProperties());
    public static String getURLSeparator()
    {
        return PROPERTIES.getProperty("file.separator");
    }

    public static void main(String[] args) {
        System.out.println(getURLSeparator());
    }
}
