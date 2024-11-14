package com.easychat.service;


import java.util.List;
import com.easychat.entity.vo.PaginationResultVO;
import com.easychat.entity.po.UserInfoBeauty;
import com.easychat.entity.query.UserInfoBeautyQuery;
/**
 * @Description: 靓号表 Service
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
public interface UserInfoBeautyService{

	/**
 	 * 根据条件查询列表
 	 */
	List<UserInfoBeauty> findListByParam(UserInfoBeautyQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(UserInfoBeautyQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<UserInfoBeauty> findListByPage(UserInfoBeautyQuery query);

	/**
 	 * 新增
 	 */
	Integer add(UserInfoBeauty bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<UserInfoBeauty> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<UserInfoBeauty> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	UserInfoBeauty getUserInfoBeautyById(String id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateUserInfoBeautyById(UserInfoBeauty bean, String id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteUserInfoBeautyById(String id);

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	UserInfoBeauty getUserInfoBeautyByUserIdAndEmail(String userId, String email);

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	Integer updateUserInfoBeautyByUserIdAndEmail(UserInfoBeauty bean, String userId, String email); 

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	Integer deleteUserInfoBeautyByUserIdAndEmail(String userId, String email);

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	UserInfoBeauty getUserInfoBeautyByUserIdAndEmail(String userId, String email);

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	Integer updateUserInfoBeautyByUserIdAndEmail(UserInfoBeauty bean, String userId, String email); 

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	Integer deleteUserInfoBeautyByUserIdAndEmail(String userId, String email);
}