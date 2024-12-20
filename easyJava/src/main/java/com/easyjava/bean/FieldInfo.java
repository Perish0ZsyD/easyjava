package com.easyjava.bean;

/**
 * @ClassName FiledInfo
 * @Description
 * @Author Siyuan
 * @Date 2024/11/04/22:26
 * @Version 1.0
 */
public class FieldInfo {
    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * bean属性名称
     */
    private String propertyName;

    /**
     * 数据库字段类型
     */
    private String sqlType;

    /**
     * java类型
     */
    private String javaType;

    /**
     * 字段备注
     */
    private String comment;

    /**
     * 是否自增
     */
    private Boolean isAutoIncrement;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(Boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }
}
