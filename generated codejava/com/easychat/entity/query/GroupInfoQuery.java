package com.easychat.entity.query;

import java.util.Date;


/**
 * @Description: 
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
public class GroupInfoQuery extends BaseQuery {
	/**
 	 * 群ID 查询对象
 	 */
	private String groupId;

	private String groupIdFuzzy;

	/**
 	 * 群组名 查询对象
 	 */
	private String groupName;

	private String groupNameFuzzy;

	/**
 	 * 群主ID 查询对象
 	 */
	private String groupOwnerId;

	private String groupOwnerIdFuzzy;

	/**
 	 * 创建时间 查询对象
 	 */
	private Date createTime;

	private String createTimeStart;
	private String createTimeEnd;
	/**
 	 * 群公告 查询对象
 	 */
	private String groupNotice;

	private String groupNoticeFuzzy;

	/**
 	 * 0:直接加入 1: 管理员同意后加入 查询对象
 	 */
	private Integer joinType;

	/**
 	 * 状态 1: 正常 0: 解散 查询对象
 	 */
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

	public void setGroupIdFuzzy(String groupIdFuzzy) {
		this.groupIdFuzzy = groupIdFuzzy;
	}

	public String getGroupIdFuzzy() {
		return groupIdFuzzy;
	}

	public void setGroupNameFuzzy(String groupNameFuzzy) {
		this.groupNameFuzzy = groupNameFuzzy;
	}

	public String getGroupNameFuzzy() {
		return groupNameFuzzy;
	}

	public void setGroupOwnerIdFuzzy(String groupOwnerIdFuzzy) {
		this.groupOwnerIdFuzzy = groupOwnerIdFuzzy;
	}

	public String getGroupOwnerIdFuzzy() {
		return groupOwnerIdFuzzy;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setGroupNoticeFuzzy(String groupNoticeFuzzy) {
		this.groupNoticeFuzzy = groupNoticeFuzzy;
	}

	public String getGroupNoticeFuzzy() {
		return groupNoticeFuzzy;
	}
}