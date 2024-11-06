package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BuildMapper
 * @Description
 * @Author Siyuan
 * @Date 2024/11/06/14:42
 * @Version 1.0
 */
public class BuildMapper {
    private static final Logger logger = LoggerFactory.getLogger(BuildPo.class);

    public static void execute(TableInfo tableInfo) {
        File folder = new File(Constants.PATH_MAPPERS);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String className = tableInfo.getBeanName() + Constants.SUFFIX_MAPPERS;
        File poFile = new File(folder, className + ".java");

        try (OutputStream out = new FileOutputStream(poFile);
             OutputStreamWriter outWriter = new OutputStreamWriter(out, "utf8");
             BufferedWriter bw = new BufferedWriter(outWriter)){
            /* 生成包名 */
            bw.write("package " + Constants.PACKAGE_MAPPERS + ";");
            bw.newLine();
            bw.newLine();

            bw.write("import org.apache.ibatis.annotations.Param;");
            bw.newLine();
            bw.newLine();

            /* 生成类顶部的注解【描述、作者、功能】 */
            BuildComment.createClassComment(bw, tableInfo.getComment() + " Mapper");

            bw.write("public interface " + className + "<T, P> extends BaseMapper {");
            bw.newLine();

            Map<String, List<FieldInfo>> keyIndexMap = tableInfo.getKeyIndexMap();

            for (Map.Entry<String, List<FieldInfo>> entry : keyIndexMap.entrySet()) {
                List<FieldInfo> keyFieldInfoList = entry.getValue();

                Integer index = 0;
                StringBuilder methodName = new StringBuilder();

                StringBuilder methodParam = new StringBuilder();

                for (FieldInfo fieldInfo : keyFieldInfoList) {
                    index++;
                    methodName.append(StringUtils.upperCaseFirstLetter(fieldInfo.getPropertyName()));
                    if (index < keyFieldInfoList.size()) {
                        methodName.append("And");
                    }

                    methodParam.append("@Param(\"" + fieldInfo.getPropertyName() + "\")" + fieldInfo.getJavaType() + " " + fieldInfo.getPropertyName());
                    if (index < keyFieldInfoList.size()) {
                        methodParam.append(", ");
                    }
                }
                bw.newLine();
                BuildComment.createFieldComment(bw, "根据 " + methodName + " 查询");
                bw.write("\tT selectBy" + methodName + "(" + methodParam + ");");
                bw.newLine();

                bw.newLine();
                BuildComment.createFieldComment(bw, "根据 " + methodName + " 更新");
                bw.write("\tInteger updateBy" + methodName + "(@Param(\"bean\") T t, " + methodParam + "); ");
                bw.newLine();

                bw.newLine();
                BuildComment.createFieldComment(bw, "根据 " + methodName + " 删除");
                bw.write("\tInteger deleteBy" + methodName + "(" + methodParam + ");");
                bw.newLine();
            }

            bw.newLine();
            bw.write("}");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("创建 mappers 失败");
        }
    }
}
