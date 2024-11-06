package com.easyjava.builder;

import com.easyjava.bean.Constants;

import java.io.BufferedWriter;

import java.util.Date;

/**
 * @ClassName BuildComment
 * @Description
 * @Author Siyuan
 * @Date 2024/11/06/14:05
 * @Version 1.0
 */
public class BuildComment {
    public static void createClassComment(BufferedWriter bw, String className) {
        try {
            bw.write("/**\n");
            bw.write(" * @Description: " + className + "\n");
            bw.write(" * @Author: " + Constants.COMMENT_AUTHOR + "\n");
            bw.write(" * @Date: " + DateUtils.format(new Date(), DateUtils.YYYY_A_MM_A_DD_HH_MM_SS) + "\n");
            bw.write(" */\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createFieldComment(BufferedWriter bw, String fieldComment) {
        try {
            bw.write("	/**\n");
            bw.write(" 	 * " + fieldComment + "\n");
            bw.write(" 	 */\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createMethodComment() {

    }
}
