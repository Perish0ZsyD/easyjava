package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.PropertiesUtils;
import com.easyjava.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    private static String SQL_SHOW_TABLES = "show table status"; // 拿去数据库的表和注释
    static {
        String driverName = PropertiesUtils.getString("db.driver.name");
        String url = PropertiesUtils.getString("db.url");
        String user = PropertiesUtils.getString("db.username");
        String password = PropertiesUtils.getString("db.password");
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            logger.error("数据库连接失败", e);
        }
    }

    public static void getTables() {
        PreparedStatement ps = null;
        ResultSet tableResult = null;

        List<TableInfo> tableInfoList = new ArrayList<TableInfo>();
        try {
            ps = conn.prepareStatement(SQL_SHOW_TABLES);
            tableResult = ps.executeQuery();
            while (tableResult.next()) {
                String tableName = tableResult.getString("name");
                String tableComment = tableResult.getString("comment");
                // logger.info("table name:" + tableName + " table comment：" + tableComment);


                String beanName = tableName;
                if (Constants.IGNORE_TABLE_PREFIX) {
                    beanName = tableName.substring(tableName.indexOf("_") + 1);
                }
                beanName = processField(beanName, true); // beanName:Info beanName:InfoBeauty

                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(tableName);
                tableInfo.setBeanName(beanName);
                tableInfo.setComment(tableComment);
                tableInfo.setBeanParamName(beanName + Constants.SUFFIX_BEAN_PARAM);

                logger.info("表:{}, 备注:{}, JavaBean:{}, JavaParamBean:{}", tableInfo.getTableName(),tableInfo.getComment(), tableInfo.getBeanName(), tableInfo.getBeanParamName());
            }

        } catch (Exception e) {
            logger.error("获取表失败", e);
        } finally {
            if (tableResult != null) {
                try {
                    tableResult.close();
                } catch (SQLException e) {
                    logger.error("关闭tableResult失败", e);
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    logger.error("关闭ps失败", e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("关闭conn失败", e);
                }
            }
        }
    }

    private static String processField(String field, Boolean uperCaseFirstLetter) {
        StringBuilder sb = new StringBuilder();
        String[] fields = field.split("_");
        sb.append(uperCaseFirstLetter ? StringUtils.uperCaseFirstLetter(fields[0]) : fields[0]); // 首字母转为大写
        for (int i = 1, len = fields.length; i < len; i++) { // 划分名称，需要考虑下划线太多，采用StringUtils类
            sb.append(StringUtils.uperCaseFirstLetter(fields[i]));
        }
        return sb.toString();
    }
}
