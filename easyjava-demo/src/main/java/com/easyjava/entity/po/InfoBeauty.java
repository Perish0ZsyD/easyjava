package com.easyjava.entity.po;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @Description: InfoBeauty
 * @Author: false
 * @Date: 2024/11/08 14:52:20
 */
public class InfoBeauty implements Serializable {
	/**
 	 * 自增ID
 	 */
	private String id;

	/**
 	 * 
 	 */
	private String email;

	/**
 	 * 
 	 */
	private String userId;

	/**
 	 * 0：未使用，1：已使用
 	 */
	@JsonIgnore
	private Integer status;


	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "自增ID:" + (id == null ? "空" : id) + "," + 
				":" + (email == null ? "空" : email) + "," + 
				":" + (userId == null ? "空" : userId) + "," + 
				"0：未使用，1：已使用:" + (status == null ? "空" : status);
		}
}