package com.easyjava.builder;

import com.easyjava.bean.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BuildBase
 * @Description
 * @Author Siyuan
 * @Date 2024/11/06/14:42
 * @Version 1.0
 */
public class BuildBase {
    private static final Logger logger = LoggerFactory.getLogger(BuildBase.class);

    public static void execute() {
        List<String> headerInfoList = new ArrayList<>();

        headerInfoList.add("package " + Constants.PACKAGE_ENUMS);
        build(headerInfoList, "DateTimePatternEnum", Constants.PATH_ENUMS);

        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_UTILS);
        build(headerInfoList, "DateUtils", Constants.PATH_UTILS);

        /* 生成 BaseMapper */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_MAPPERS);
        build(headerInfoList, "BaseMapper", Constants.PATH_MAPPERS);

        /* 生成 pageSize 枚举 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_ENUMS);
        build(headerInfoList, "PageSize", Constants.PATH_ENUMS);

        /* 生成 SimplePage 类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_QUERY);
        headerInfoList.add("import " + Constants.PACKAGE_ENUMS + ".PageSize;");
        build(headerInfoList, "SimplePage", Constants.PATH_QUERY);

        /* 生成 BaseQuery 类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_QUERY);
        build(headerInfoList, "BaseQuery", Constants.PATH_QUERY);

        /* 生成 PaginationResultVO 类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_VO);
        build(headerInfoList, "PaginationResultVO", Constants.PATH_VO);

        /* 生成 BusinessException 类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_EXCEPTION);
        headerInfoList.add("import " + Constants.PACKAGE_ENUMS + ".ResponseCodeEnum;");
        build(headerInfoList, "BusinessException", Constants.PATH_EXCEPTION);

        /* 生成 ResponseCodeEnum 类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_ENUMS);
        build(headerInfoList, "ResponseCodeEnum", Constants.PATH_ENUMS);

        /* 生成 ResponseVO 类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_VO);
        build(headerInfoList, "ResponseVO", Constants.PATH_VO);

        /* ---------- controller 层 ---------- */

        /* 生成 ABaseController 类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_CONTROLLER);
        headerInfoList.add("import " + Constants.PACKAGE_VO + ".ResponseVO;");
        headerInfoList.add("import " + Constants.PACKAGE_ENUMS + ".ResponseCodeEnum;");
        build(headerInfoList, "ABaseController", Constants.PATH_CONTROLLER);

        /* AGlobalExceptionHandlerController 全局异常类 */
        headerInfoList.clear();
        headerInfoList.add("package " + Constants.PACKAGE_CONTROLLER);
        headerInfoList.add("import " + Constants.PACKAGE_VO + ".ResponseVO;");
        headerInfoList.add("import " + Constants.PACKAGE_ENUMS + ".ResponseCodeEnum;");
        headerInfoList.add("import " + Constants.PACKAGE_EXCEPTION + ".BusinessException;");
        build(headerInfoList, "AGlobalExceptionHandlerController", Constants.PATH_CONTROLLER);

    }

    /**
     * @Description 生成基础类
     * @param headerInfoList
     * @param fileName
     * @param outPutPath
     */
    private static void build(List<String> headerInfoList, String fileName, String outPutPath) {

        File folder = new File(outPutPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File javaFile = new File(outPutPath, fileName + ".java");

        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;

        InputStream in = null;
        InputStreamReader inr = null;
        BufferedReader bf = null;

        try {
            out = Files.newOutputStream(javaFile.toPath());
            outw = new OutputStreamWriter(out, "utf-8");
            bw = new BufferedWriter(outw);

            String templatePath = BuildBase.class.getClassLoader().getResource("template/" + fileName + ".txt").getPath().substring(1);

            in = Files.newInputStream(Paths.get(templatePath));
            inr = new InputStreamReader(in, "utf-8");
            bf = new BufferedReader(inr);

            for (String head : headerInfoList) {
                bw.write(head + ";\n");
                bw.newLine();
            }


            String lineInfo = null;
            while ((lineInfo = bf.readLine()) != null) {
                bw.write(lineInfo);
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
        } catch (Exception e) {
            logger.error("生成基础类失败: {},失败" + fileName, e);
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inr != null) {
                try {
                    inr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (outw != null) {
                try {
                    outw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
