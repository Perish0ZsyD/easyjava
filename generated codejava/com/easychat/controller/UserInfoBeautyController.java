package com.easychat.controller;


import java.util.List;
import com.easychat.service.UserInfoBeautyService;
import com.easychat.entity.vo.ResponseVO;
import com.easychat.entity.po.UserInfoBeauty;
import com.easychat.entity.query.UserInfoBeautyQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/**
 * @Description: 靓号表 Controller
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
@RestController
@RequestMapping("/userInfoBeauty")
public class UserInfoBeautyController extends ABaseController{

	@Resource
	private UserInfoBeautyService userInfoBeautyService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(UserInfoBeautyQuery query) {
		return getSuccessResponseVO(userInfoBeautyService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(UserInfoBeauty bean) {
		Integer result = this.userInfoBeautyService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<UserInfoBeauty> listBean) {
		this.userInfoBeautyService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<UserInfoBeauty> listBean) {
		this.userInfoBeautyService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getUserInfoBeautyById")
	public ResponseVO getUserInfoBeautyById(String id) {
		return getSuccessResponseVO(userInfoBeautyService.getUserInfoBeautyById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateUserInfoBeautyById")
	public ResponseVO updateUserInfoBeautyById(UserInfoBeauty bean, String id) {
		this.userInfoBeautyService.updateUserInfoBeautyById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteUserInfoBeautyById")
	public ResponseVO deleteUserInfoBeautyById(String id) {
		this.userInfoBeautyService.deleteUserInfoBeautyById(id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@RequestMapping("/getUserInfoBeautyByUserIdAndEmail")
	public ResponseVO getUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		return getSuccessResponseVO(userInfoBeautyService.getUserInfoBeautyByUserIdAndEmail(userId, email));}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@RequestMapping("/updateUserInfoBeautyByUserIdAndEmail")
	public ResponseVO updateUserInfoBeautyByUserIdAndEmail(UserInfoBeauty bean, String userId, String email) {
		this.userInfoBeautyService.updateUserInfoBeautyByUserIdAndEmail(bean, userId, email);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@RequestMapping("/deleteUserInfoBeautyByUserIdAndEmail")
	public ResponseVO deleteUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		this.userInfoBeautyService.deleteUserInfoBeautyByUserIdAndEmail(userId, email);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@RequestMapping("/getUserInfoBeautyByUserIdAndEmail")
	public ResponseVO getUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		return getSuccessResponseVO(userInfoBeautyService.getUserInfoBeautyByUserIdAndEmail(userId, email));}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@RequestMapping("/updateUserInfoBeautyByUserIdAndEmail")
	public ResponseVO updateUserInfoBeautyByUserIdAndEmail(UserInfoBeauty bean, String userId, String email) {
		this.userInfoBeautyService.updateUserInfoBeautyByUserIdAndEmail(bean, userId, email);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@RequestMapping("/deleteUserInfoBeautyByUserIdAndEmail")
	public ResponseVO deleteUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		this.userInfoBeautyService.deleteUserInfoBeautyByUserIdAndEmail(userId, email);
		return getSuccessResponseVO(null);
}
}