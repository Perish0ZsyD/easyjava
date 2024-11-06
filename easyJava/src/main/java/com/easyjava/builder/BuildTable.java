package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;

import com.easyjava.utils.PropertiesUtils;
import com.easyjava.utils.StringUtils;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BuildTable
 * @Description 读取数据库的表 通过JDBC
 * @Author Siyuan
 * @Date 2024/11/04/22:05
 * @Version 1.0
 */
public class BuildTable {
    private static final Logger logger = LoggerFactory.getLogger(BuildTable.class);

    private static Connection conn = null;
    //可以获取 table 的更多信息
    private static final String SQL_SHOW_TABLE_STATUS = "show table status";

    private static final String SQL_SHOW_TABLE_FIELDS = "show full fields from %s";

    private static final String SQL_SHOW_TABLE_INDEX = "show index from %s";

    static {
        String driverName = PropertiesUtils.getString("db.driver.name");
        String url = PropertiesUtils.getString("db.url");
        String username = PropertiesUtils.getString("db.username");
        String password = PropertiesUtils.getString("db.password");
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            logger.error("数据库连接失败", e);
        }
    }


    public static List<TableInfo> getTables() {

        List<TableInfo> tableInfoList = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(SQL_SHOW_TABLE_STATUS);
             ResultSet tableResult = ps.executeQuery()) {
            while (tableResult.next()) {
                String tableName = tableResult.getString("name");
                String tableComment = tableResult.getString("comment");

                String beanName = tableName;
                if (Constants.IGNORE_TABLE_PREFIX) {
                    beanName = tableName.substring(beanName.indexOf("_") + 1);
                }
                beanName = processField(beanName, true); // beanName:Info beanName:InfoBeauty

                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(tableName);
                tableInfo.setBeanName(beanName);
                tableInfo.setComment(tableComment);
                tableInfo.setBeanParamName(beanName + Constants.SUFFIX_BEAN_QUERY);

                readFieldInfo(tableInfo); // 读取字段信息
                getKeyIndexInfo(tableInfo);

                tableInfoList.add(tableInfo);

            }
        } catch (Exception e) {
            logger.error("获取表失败", e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("关闭conn失败", e);
                }
            }
        }
        return tableInfoList;
    }

    /**
     * Process读取字段信息
     *
     * @param tableInfo
     */
    private static List<FieldInfo> readFieldInfo(TableInfo tableInfo) {
        List<FieldInfo> fieldInfoList = new ArrayList<>();

        List<FieldInfo> fieldExtendList = new ArrayList<>();

        try (PreparedStatement ps =conn.prepareStatement(String.format(SQL_SHOW_TABLE_FIELDS, tableInfo.getTableName()));
             ResultSet fieldResult = ps.executeQuery()) {

            Boolean haveDateTime = false;
            Boolean haveDate = false;
            Boolean haveBigDecimal = false;

            while (fieldResult.next()) {
                String field = fieldResult.getString("field");
                String type = fieldResult.getString("type");
                String extra = fieldResult.getString("extra");
                String comment = fieldResult.getString("comment");

                if (type.indexOf("(") > 0) {
                    type =type.substring(0, type.indexOf("("));
                }
                String propertyName = processField(field, false);
                FieldInfo fieldInfo = new FieldInfo();

                fieldInfo.setFieldName(field);
                fieldInfo.setSqlType(type);
                fieldInfo.setComment(comment);
                fieldInfo.setAutoIncrement("auto_increment".equalsIgnoreCase(extra) ? true : false);
                fieldInfo.setPropertyName(propertyName);
                fieldInfo.setJavaType(processJavaType(type)); // 把sqltype转换成javaType

                fieldInfoList.add(fieldInfo);
                tableInfo.setFieldList(fieldInfoList);

                // 判断表是否有时间类型,是否有bigDecimal类型
                //logger.info("javaType:{}", fieldInfo.getJavaType());

                if (ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPES, type)) {
                    haveDateTime = true;
                }
                if (ArrayUtils.contains(Constants.SQL_DATE_TYPES, type)) {
                    haveDate = true;
                }
                if (ArrayUtils.contains(Constants.SQL_DECIMAL_TYPES, type)) {
                    haveBigDecimal = true;
                }

                /* String 类型 */
                if (ArrayUtils.contains(Constants.SQL_STRING_TYPES, type)) {

                    FieldInfo fuzzyField = new FieldInfo();
                    fuzzyField.setJavaType(fieldInfo.getJavaType());
                    fuzzyField.setPropertyName(propertyName + Constants.SUFFIX_BEAN_QUERY_FUZZY);
                    fuzzyField.setFieldName(fieldInfo.getFieldName());
                    fuzzyField.setSqlType(type);
                    fieldExtendList.add(fuzzyField);
                }


            }
            tableInfo.setHaveDateTime(haveDateTime);
            tableInfo.setHaveDate(haveDate);
            tableInfo.setHaveBigDecimal(haveBigDecimal);
            tableInfo.setFieldList(fieldInfoList);
            tableInfo.setFieldExtendList(fieldExtendList);
        } catch (Exception e) {
            logger.error("获取Field失败", e);
        }
        return fieldInfoList;
    }

    private static List<FieldInfo> getKeyIndexInfo(TableInfo tableInfo) {

        List<FieldInfo> fieldInfoList = new ArrayList<>();
        // 定义一个临时的缓存Map
        Map<String, FieldInfo> tempMap = new HashMap<>();

        for (FieldInfo fieldInfo : tableInfo.getFieldList()) {
            tempMap.put(fieldInfo.getFieldName(), fieldInfo);
        }

        try (PreparedStatement ps = conn.prepareStatement(String.format(SQL_SHOW_TABLE_INDEX, tableInfo.getTableName()));
             ResultSet fieldResult = ps.executeQuery()){

            while (fieldResult.next()) {
                String keyName = fieldResult.getString("key_name");
                Integer nonUnique = fieldResult.getInt("non_unique");
                String columnName = fieldResult.getString("column_name");
                if (nonUnique == 1) {
                    continue;
                }
                List<FieldInfo> keyFieldList = tableInfo.getKeyIndexMap().get(keyName);

                if (null == keyFieldList) {
                    keyFieldList = new ArrayList<>();
                    tableInfo.getKeyIndexMap().put(keyName, keyFieldList);
                }
// 上面Map优化
//                for (FieldInfo fieldInfo : tableInfo.getFieldList()) {
//                    if (fieldInfo.getFieldName().equals(columnName)) {
//                        keyFieldList.add(fieldInfo);
//                    }
//                }
                keyFieldList.add(tempMap.get(columnName));
            }
        } catch (Exception e) {
            logger.error("获取索引失败", e);
        }
        return fieldInfoList;
    }

    private static String processField(String field, Boolean upperCaseFirstLetter) {
        StringBuffer sb = new StringBuffer();
        String[] fields = field.split("_");
        sb.append(upperCaseFirstLetter ? StringUtils.upperCaseFirstLetter(fields[0]) : fields[0]); // 首字母转为大写
        for (int i = 1, len = fields.length; i < len; i++) { // 划分名称，需要考虑下划线太多，采用StringUtils类
            sb.append(StringUtils.upperCaseFirstLetter(fields[i]));
        }
        return sb.toString();
    }

    private static String processJavaType(String type) {
        if (ArrayUtils.contains(Constants.SQL_INTEGER_TYPES, type)) {
            return "Integer";
        } else if (ArrayUtils.contains(Constants.SQL_LONG_TYPES, type)) {
            return "Long";
        } else if (ArrayUtils.contains(Constants.SQL_DATE_TYPES, type) || ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPES, type)) {
            return "Date";
        } else if (ArrayUtils.contains(Constants.SQL_DECIMAL_TYPES, type)) {
            return "BigDecimal";
        } else if (ArrayUtils.contains(Constants.SQL_STRING_TYPES, type)) {
            return "String";
        } else {
            throw new RuntimeException("未知类型：" + type);
        }
    }
}
