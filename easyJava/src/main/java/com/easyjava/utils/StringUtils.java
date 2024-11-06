package com.easyjava.utils;

/**
 * @ClassName StringUtils
 * @Description 把一个字符串的第一个字母大写、效率是最高的
 * @Author Siyuan
 * @Date 2024/11/04/22:42
 * @Version 1.0
 */
public class StringUtils {
    /**
     * 把首字母转化为大写
     * @param field
     * @return
     */
    public static String upperCaseFirstLetter(String field) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(field)) {
            return field;
        }
        return field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    /**
     * @首字母转化为小写
     * @param field
     * @return
     */
    public static String lowerCaseFirstLetter(String field) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(field)) {
            return field;
        }
        return field.substring(0, 1).toLowerCase() + field.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(upperCaseFirstLetter("company"));
        System.out.println(lowerCaseFirstLetter("Company"));
    }
}
