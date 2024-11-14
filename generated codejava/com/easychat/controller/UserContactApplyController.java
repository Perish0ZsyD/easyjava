package com.easychat.controller;


import java.util.List;
import com.easychat.service.UserContactApplyService;
import com.easychat.entity.vo.ResponseVO;
import com.easychat.entity.po.UserContactApply;
import com.easychat.entity.query.UserContactApplyQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/**
 * @Description: 申请人信息 Controller
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
@RestController
@RequestMapping("/userContactApply")
public class UserContactApplyController extends ABaseController{

	@Resource
	private UserContactApplyService userContactApplyService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(UserContactApplyQuery query) {
		return getSuccessResponseVO(userContactApplyService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(UserContactApply bean) {
		Integer result = this.userContactApplyService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<UserContactApply> listBean) {
		this.userContactApplyService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<UserContactApply> listBean) {
		this.userContactApplyService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 ApplyId 查询
 	 */
	@RequestMapping("/getUserContactApplyByApplyId")
	public ResponseVO getUserContactApplyByApplyId(Integer applyId) {
		return getSuccessResponseVO(userContactApplyService.getUserContactApplyByApplyId(applyId));}

	/**
 	 * 根据 ApplyId 更新
 	 */
	@RequestMapping("/updateUserContactApplyByApplyId")
	public ResponseVO updateUserContactApplyByApplyId(UserContactApply bean, Integer applyId) {
		this.userContactApplyService.updateUserContactApplyByApplyId(bean, applyId);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 ApplyId 删除
 	 */
	@RequestMapping("/deleteUserContactApplyByApplyId")
	public ResponseVO deleteUserContactApplyByApplyId(Integer applyId) {
		this.userContactApplyService.deleteUserContactApplyByApplyId(applyId);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 ApplyUserIdAndReceiveUserIdAndContactId 查询
 	 */
	@RequestMapping("/getUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId")
	public ResponseVO getUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(String applyUserId, String receiveUserId, String contactId) {
		return getSuccessResponseVO(userContactApplyService.getUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(applyUserId, receiveUserId, contactId));}

	/**
 	 * 根据 ApplyUserIdAndReceiveUserIdAndContactId 更新
 	 */
	@RequestMapping("/updateUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId")
	public ResponseVO updateUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(UserContactApply bean, String applyUserId, String receiveUserId, String contactId) {
		this.userContactApplyService.updateUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(bean, applyUserId, receiveUserId, contactId);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 ApplyUserIdAndReceiveUserIdAndContactId 删除
 	 */
	@RequestMapping("/deleteUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId")
	public ResponseVO deleteUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(String applyUserId, String receiveUserId, String contactId) {
		this.userContactApplyService.deleteUserContactApplyByApplyUserIdAndReceiveUserIdAndContactId(applyUserId, receiveUserId, contactId);
		return getSuccessResponseVO(null);
}
}