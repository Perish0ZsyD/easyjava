package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.StringUtils;
import javafx.scene.control.Tab;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;

import java.io.*;

/**
 * @ClassName BuildPO
 * @Description
 * @Author Siyuan
 * @Date 2024/11/06/11:47
 * @Version 1.0
 */
public class BuildPo {
    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(BuildPo.class);

    public static void execute(TableInfo tableInfo) {
        File folder = new File(Constants.PATH_PO);
        if (!folder.exists()) { // 如果文件夹不存在,则创建文件夹
            folder.mkdirs();
        }
        File poFile = new File(folder, tableInfo.getBeanName() + ".java");
        try (OutputStream out = new FileOutputStream(poFile);
             OutputStreamWriter outw = new OutputStreamWriter(out, "utf-8");
             BufferedWriter bw = new BufferedWriter(outw)) {

            bw.write("package " + Constants.PACKAGE_PO + ";");
            bw.newLine();
            bw.newLine();

            /* 如果存在日期类型Date or DateTime，导入 */
            if (tableInfo.getHaveDate() || tableInfo.getHaveDateTime()) {
                bw.newLine();
                bw.write("import " + Constants.PACKAGE_ENUMS + ".DateTimePatternEnum;");
                bw.newLine();
                bw.write("import " + Constants.PACKAGE_UTILS + ".DateUtils;");
                bw.newLine();
                bw.write("import java.util.Date;");
                bw.newLine();
                bw.write(Constants.BEAN_DATE_FORMAT_CLASS);
                bw.newLine();
                bw.write(Constants.BEAN_DATE_UNFORMAT_CLASS);
            }

            /* 是否存在忽略属性 */
            Boolean haveIgnoreBean = false;
            /* 如果存在就不导入包 */
            for (FieldInfo field : tableInfo.getFieldList()) {
                if (ArrayUtils.contains(Constants.IGNORE_BEAN_TOJSON_FIELD.split(","), field.getPropertyName())) {
                    haveIgnoreBean = true;
                    break;
                }
            }
            /* 如果存在就导入包 */
            if (haveIgnoreBean) {
                /* 导入 @JsonIgnore 所属的包 */
                bw.write("\n" + String.format(Constants.IGNORE_BEAN_TOJSON_CLASS) + "\n");
            }

            /* 引入序列化包 */
            bw.write("import java.io.Serializable;");
            bw.newLine();

            /* 如果存在BigDecimal类型，则引入包*/
            if (tableInfo.getHaveBigDecimal()) {
                bw.write("import java.math.BigDecimal;");
            }

            bw.newLine();
            bw.newLine();

            /* 生成类顶部的注解【描述、作者、功能】 */
            BuildComment.createClassComment(bw, tableInfo.getBeanName());
            /* 生成主类和序列化接口 */
            bw.write("public class " + tableInfo.getBeanName() + " implements Serializable {");
            bw.newLine();


            for (FieldInfo field : tableInfo.getFieldList()) { // 遍历获取字段，但需要判断是否加入注解
                BuildComment.createFieldComment(bw, field.getComment()); // 每个属性增加注解

                /* 存在 SQL_DATE_TIME_TYPES 类型 */
                if (ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPES, field.getSqlType())) {
                    /* 生成时间格式序列化 */
                    bw.write("\t" + String.format(Constants.BEAN_DATE_FORMAT_EXPRESSION, DateUtils.YYYY_MM_DD_HH_MM_SS) + "\n");

                    /* 生成时间格式反序列化 */
                    bw.write("\t" + String.format(Constants.BEAN_DATE_UNFORMAT_EXPRESSION, DateUtils.YYYY_MM_DD_HH_MM_SS) + "\n");
                }

                /* 存在 SQL_DATE_TYPES 类型 */
                if (ArrayUtils.contains(Constants.SQL_DATE_TYPES, field.getSqlType())) {
                    /* 生成时间格式序列化 */
                    bw.write("\t" + String.format(Constants.BEAN_DATE_FORMAT_EXPRESSION, DateUtils.YYYY_MM_DD) + "\n");

                    /* 生成时间格式反序列化 */
                    bw.write("\t" + String.format(Constants.BEAN_DATE_UNFORMAT_EXPRESSION, DateUtils.YYYY_MM_DD) + "\n");
                }

                /* 存在忽略表的字段 */
                if (ArrayUtils.contains(Constants.IGNORE_BEAN_TOJSON_FIELD.split(","), field.getPropertyName())) {
                    /* 生成忽略字段注解 @JsonIgnore */
                    bw.write("\t" + String.format(Constants.IGNORE_BEAN_TOJSON_EXPRESSION) + "\n");
                }

                bw.write("\tprivate " + field.getJavaType() + " " + field.getPropertyName() + ";");
                bw.newLine(); // 换行
                bw.newLine();
            }

            /* 生成 PO 的 set 和 get 方法 */
            for (FieldInfo field : tableInfo.getFieldList()) {
                String tempField = StringUtils.upperCaseFirstLetter(field.getPropertyName());
                // set
                bw.write("\n\tpublic void set" + tempField + "(" + field.getJavaType() + " " + field.getPropertyName() + ") {");
                bw.newLine();
                bw.write("\t\tthis." + field.getPropertyName() + " = " + field.getPropertyName() + ";");
                bw.newLine();
                bw.write("\t}" + "\n");

                // get
                bw.write("\n\tpublic " + field.getJavaType() + " get" + tempField + "() {");
                bw.newLine();
                bw.write("\t\treturn " + field.getPropertyName() + ";");
                bw.newLine();
                bw.write("\t}" + "\n");
            }

            /* 重写 toString 方法 */
            StringBuffer toString = new StringBuffer();
            Integer index = 0;
            for (FieldInfo field : tableInfo.getFieldList()) {
                index++;

                String properName = field.getPropertyName();
                if (ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPES, field.getSqlType())) {
                    properName = "DateUtils.format(" + properName + ", DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())";
                } else if (ArrayUtils.contains(Constants.SQL_DATE_TYPES, field.getSqlType())) {
                    properName = "DateUtils.format(" + properName + ", DateTimePatternEnum.YYYY_MM_DD.getPattern())";
                }

                toString.append(field.getComment() + ":\" + (" + field.getPropertyName()
                        + " == null ? \"空\" : " + properName + ")");
                if (index < tableInfo.getFieldList().size()) { // 如果当前字段不是列表中的最后一个字段，则在 toString 缓冲区中添加一个分隔符以正确格式化输出
                    toString.append(" + ").append("\"," + "\" + \n\t\t\t\t\"");

                }
            }
            String toStringStr = toString.toString();
            toStringStr = "\"" + toStringStr;
            bw.write("\t@Override\n");
            bw.write("\tpublic String toString() {\n");
            bw.write("\t\treturn " + toStringStr + ";\n");
            bw.write("\t\t}\n");

            bw.write("}");
            bw.flush();
        } catch (Exception e) {
            logger.error("创建PO失败", e);
        }

    }
}
