package com.easyjava.service;


import java.util.List;
import com.easyjava.entity.vo.PaginationResultVO;
import com.easyjava.entity.po.InfoBeauty;
import com.easyjava.entity.query.InfoBeautyQuery;
/**
 * @Description: 靓号表 Service
 * @Author: false
 * @Date: 2024/11/06 22:46:25
 */
public interface InfoBeautyService{

	/**
 	 * 根据条件查询列表
 	 */
	List<InfoBeauty> findListByParam(InfoBeautyQuery query);

	/**
 	 * 根据条件查询数量
 	 */
	Integer findCountByParam(InfoBeautyQuery query);

	/**
 	 * 分页查询
 	 */
	PaginationResultVO<InfoBeauty> findListByPage(InfoBeautyQuery query);

	/**
 	 * 新增
 	 */
	Integer add(InfoBeauty bean);

	/**
 	 * 批量新增
 	 */
	Integer addBatch(List<InfoBeauty> listBean);

	/**
 	 * 批量新增或修改
 	 */
	Integer addOrUpdateBatch(List<InfoBeauty> listBean);

	/**
 	 * 根据 Id 查询
 	 */
	InfoBeauty getInfoBeautyById(String id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateInfoBeautyById(InfoBeauty bean, String id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteInfoBeautyById(String id);

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	InfoBeauty getInfoBeautyByUserIdAndEmail(String userId, String email);

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	Integer updateInfoBeautyByUserIdAndEmail(InfoBeauty bean, String userId, String email); 

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	Integer deleteInfoBeautyByUserIdAndEmail(String userId, String email);

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	InfoBeauty getInfoBeautyByUserIdAndEmail(String userId, String email);

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	Integer updateInfoBeautyByUserIdAndEmail(InfoBeauty bean, String userId, String email); 

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	Integer deleteInfoBeautyByUserIdAndEmail(String userId, String email);
}