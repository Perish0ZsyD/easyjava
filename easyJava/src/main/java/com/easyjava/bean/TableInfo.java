package com.easyjava.bean;


import com.easyjava.bean.FieldInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TableInfo
 * @Description
 * @Author Siyuan
 * @Date 2024/11/04/22:21
 * @Version 1.0
 */
public class TableInfo {
    /**
     * 表名称
     */
    String tableName;

    /**
     * bean名称
     */
    String beanName;

    /**
     * 参数名称
     */
    String beanParamName;

    /**
     * 表注释
     */
    String comment;

    /**
     * 字段信息
     */
    List<FieldInfo> fieldList;

    /**
     * 唯一索引集合
     * 使用LinkedHashMap保证顺序
     */
    Map<String, List<FieldInfo>> keyIndexMap = new LinkedHashMap<String, List<FieldInfo>>();

    /**
     * 是否有date类型
     */
    Boolean haveDate;

    /**
     * 是否有时间类型
     */
    Boolean haveDatetime;

    /**
     * 是否有bigDecimal类型
     */
    Boolean haveBigDecimal;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanParamName() {
        return beanParamName;
    }

    public void setBeanParamName(String beanParamName) {
        this.beanParamName = beanParamName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<FieldInfo> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<FieldInfo> fieldList) {
        this.fieldList = fieldList;
    }

    public Map<String, List<FieldInfo>> getKeyIndexMap() {
        return keyIndexMap;
    }

    public void setKeyIndexMap(Map<String, List<FieldInfo>> keyIndexMap) {
        this.keyIndexMap = keyIndexMap;
    }

    public Boolean getHaveDate() {
        return haveDate;
    }

    public void setHaveDate(Boolean haveDate) {
        this.haveDate = haveDate;
    }

    public Boolean getHaveDatetime() {
        return haveDatetime;
    }

    public void setHaveDatetime(Boolean haveDatetime) {
        this.haveDatetime = haveDatetime;
    }

    public Boolean getHaveBigDecimal() {
        return haveBigDecimal;
    }

    public void setHaveBigDecimal(Boolean haveBigDecimal) {
        this.haveBigDecimal = haveBigDecimal;
    }
}
