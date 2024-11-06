package com.easyjava.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * @Description: 靓号表 Mapper
 * @Author: false
 * @Date: 2024/11/06 18:47:59
 */
public interface InfoBeautyMapper<T, P> extends BaseMapper {

	/**
 	 * 根据 Id 查询
 	 */
	T selectById(@Param("id")String id);

	/**
 	 * 根据 Id 更新
 	 */
	Integer updateById(@Param("bean") T t, @Param("id")String id); 

	/**
 	 * 根据 Id 删除
 	 */
	Integer deleteById(@Param("id")String id);

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	T selectByUserIdAndEmail(@Param("userId")String userId, @Param("email")String email);

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	Integer updateByUserIdAndEmail(@Param("bean") T t, @Param("userId")String userId, @Param("email")String email); 

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	Integer deleteByUserIdAndEmail(@Param("userId")String userId, @Param("email")String email);

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	T selectByUserIdAndEmail(@Param("userId")String userId, @Param("email")String email);

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	Integer updateByUserIdAndEmail(@Param("bean") T t, @Param("userId")String userId, @Param("email")String email); 

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	Integer deleteByUserIdAndEmail(@Param("userId")String userId, @Param("email")String email);

}