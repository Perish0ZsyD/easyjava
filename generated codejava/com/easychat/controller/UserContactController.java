package com.easychat.controller;


import java.util.List;
import com.easychat.service.UserContactService;
import com.easychat.entity.vo.ResponseVO;
import com.easychat.entity.po.UserContact;
import com.easychat.entity.query.UserContactQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/**
 * @Description: 联系人 Controller
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
@RestController
@RequestMapping("/userContact")
public class UserContactController extends ABaseController{

	@Resource
	private UserContactService userContactService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(UserContactQuery query) {
		return getSuccessResponseVO(userContactService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(UserContact bean) {
		Integer result = this.userContactService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<UserContact> listBean) {
		this.userContactService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<UserContact> listBean) {
		this.userContactService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 UserIdAndContactId 查询
 	 */
	@RequestMapping("/getUserContactByUserIdAndContactId")
	public ResponseVO getUserContactByUserIdAndContactId(String userId, String contactId) {
		return getSuccessResponseVO(userContactService.getUserContactByUserIdAndContactId(userId, contactId));}

	/**
 	 * 根据 UserIdAndContactId 更新
 	 */
	@RequestMapping("/updateUserContactByUserIdAndContactId")
	public ResponseVO updateUserContactByUserIdAndContactId(UserContact bean, String userId, String contactId) {
		this.userContactService.updateUserContactByUserIdAndContactId(bean, userId, contactId);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndContactId 删除
 	 */
	@RequestMapping("/deleteUserContactByUserIdAndContactId")
	public ResponseVO deleteUserContactByUserIdAndContactId(String userId, String contactId) {
		this.userContactService.deleteUserContactByUserIdAndContactId(userId, contactId);
		return getSuccessResponseVO(null);
}
}