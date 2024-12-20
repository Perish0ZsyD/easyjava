package com.easychat.entity.po;

import java.io.Serializable;

import com.easychat.enums.DateTimePatternEnum;
import com.easychat.utils.DateUtils;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @Description: GroupInfo
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
public class GroupInfo implements Serializable {
	/**
 	 * 群ID
 	 */
	private String groupId;

	/**
 	 * 群组名
 	 */
	private String groupName;

	/**
 	 * 群主ID
 	 */
	private String groupOwnerId;

	/**
 	 * 创建时间
 	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * 群公告
 	 */
	private String groupNotice;

	/**
 	 * 0:直接加入 1: 管理员同意后加入
 	 */
	private Integer joinType;

	/**
 	 * 状态 1: 正常 0: 解散
 	 */
	@JsonIgnore
	private Integer status;


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupOwnerId(String groupOwnerId) {
		this.groupOwnerId = groupOwnerId;
	}

	public String getGroupOwnerId() {
		return groupOwnerId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setGroupNotice(String groupNotice) {
		this.groupNotice = groupNotice;
	}

	public String getGroupNotice() {
		return groupNotice;
	}

	public void setJoinType(Integer joinType) {
		this.joinType = joinType;
	}

	public Integer getJoinType() {
		return joinType;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "群ID:" + (groupId == null ? "空" : groupId) + "," + 
				"群组名:" + (groupName == null ? "空" : groupName) + "," + 
				"群主ID:" + (groupOwnerId == null ? "空" : groupOwnerId) + "," + 
				"创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + 
				"群公告:" + (groupNotice == null ? "空" : groupNotice) + "," + 
				"0:直接加入 1: 管理员同意后加入:" + (joinType == null ? "空" : joinType) + "," + 
				"状态 1: 正常 0: 解散:" + (status == null ? "空" : status);
		}
}