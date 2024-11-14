package com.easychat.service;


import java.util.List;
import com.easychat.entity.vo.PaginationResultVO;
import com.easychat.entity.po.UserContactApply;
import com.easychat.entity.query.UserContactApplyQuery;
/**
 * @Description: 申请人信息 Service
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
public interface UserContactApplyService{

	/**
 	 * 根据条件查询列表
 	 */
	List<UserContactApply> findListByParam(UserContactApplyQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(UserContactApplyQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<UserContactApply> findListByPage(UserContactApplyQuery query);

	/**
 	 * 新增
 	 */
	Integer add(UserContactApply bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<UserContactApply> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<UserContactApply> listBean);

	/**
 	 * 根据 ApplyId 查询
 	 */
	UserContactApply getUserContactApplyByApplyId(Integer applyId);

	/**
 	 * 根据 ApplyId 更新
 	 */
	Integer updateUserContactApplyByApplyId(UserContactApply bean, Integer applyId); 

	/**
 	 * 根据 ApplyId 删除
 	 */
	Integer deleteUserContactApplyByApplyId(Integer applyId);

	/**
 	 * 根据 ApplyUserIdAndReceiveUserIdAndContactId 查询
 	 */
	UserContactApply getUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(String applyUserId, String receiveUserId, String contactId);

	/**
 	 * 根据 ApplyUserIdAndReceiveUserIdAndContactId 更新
 	 */
	Integer updateUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(UserContactApply bean, String applyUserId, String receiveUserId, String contactId); 

	/**
 	 * 根据 ApplyUserIdAndReceiveUserIdAndContactId 删除
 	 */
	Integer deleteUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(String applyUserId, String receiveUserId, String contactId);
}