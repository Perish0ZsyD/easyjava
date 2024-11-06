package com.easyjava.service;


import java.util.List;
import com.easyjava.entity.vo.PaginationResultVO;
import com.easyjava.entity.po.Info;
import com.easyjava.entity.query.InfoQuery;
/**
 * @Description: 用户信息表 Service
 * @Author: false
 * @Date: 2024/11/06 22:46:25
 */
public interface InfoService{

	/**
 	 * 根据条件查询列表
 	 */
	List<Info> findListByParam(InfoQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(InfoQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<Info> findListByPage(InfoQuery query);

	/**
 	 * 新增
 	 */
	Integer add(Info bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<Info> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<Info> listBean);

	/**
 	 * 根据 UserId 查询
 	 */
	Info getInfoByUserId(String userId);

	/**
 	 * 根据 UserId 更新
 	 */
	Integer updateInfoByUserId(Info bean, String userId); 

	/**
 	 * 根据 UserId 删除
 	 */
	Integer deleteInfoByUserId(String userId);

	/**
 	 * 根据 Email 查询
 	 */
	Info getInfoByEmail(String email);

	/**
 	 * 根据 Email 更新
 	 */
	Integer updateInfoByEmail(Info bean, String email); 

	/**
 	 * 根据 Email 删除
 	 */
	Integer deleteInfoByEmail(String email);

	/**
 	 * 根据 Email 查询
 	 */
	Info getInfoByEmail(String email);

	/**
 	 * 根据 Email 更新
 	 */
	Integer updateInfoByEmail(Info bean, String email); 

	/**
 	 * 根据 Email 删除
 	 */
	Integer deleteInfoByEmail(String email);
}