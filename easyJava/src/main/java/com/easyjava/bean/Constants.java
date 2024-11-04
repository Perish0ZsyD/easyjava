package com.easyjava.bean;

import com.easyjava.utils.PropertiesUtils;

/**
 * @ClassName Constants
 * @Description 定义常量类，用于存放一些需要定义的常量，方便管理
 * @Author Siyuan
 * @Date 2024/11/04/22:32
 * @Version 1.0
 */
public class Constants {
    public static Boolean IGNORE_TABLE_PREFIX;

    public static String SUFFIX_BEAN_PARAM;
    static {
        IGNORE_TABLE_PREFIX = Boolean.valueOf(PropertiesUtils.getString("ignore.table.prefix"));
        SUFFIX_BEAN_PARAM = PropertiesUtils.getString("suffix.bean.param");
    }
}
