package com.easychat.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * @Description: 用户信息表 Mapper
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
public interface UserInfoMapper<T, P> extends BaseMapper {

	/**
 	 * 根据 UserId 查询
 	 */
	T selectByUserId(@Param("userId")String userId);

	/**
 	 * 根据 UserId 更新
 	 */
	Integer updateByUserId(@Param("bean") T t, @Param("userId")String userId); 

	/**
 	 * 根据 UserId 删除
 	 */
	Integer deleteByUserId(@Param("userId")String userId);

	/**
 	 * 根据 Email 查询
 	 */
	T selectByEmail(@Param("email")String email);

	/**
 	 * 根据 Email 更新
 	 */
	Integer updateByEmail(@Param("bean") T t, @Param("email")String email); 

	/**
 	 * 根据 Email 删除
 	 */
	Integer deleteByEmail(@Param("email")String email);

	/**
 	 * 根据 Email 查询
 	 */
	T selectByEmail(@Param("email")String email);

	/**
 	 * 根据 Email 更新
 	 */
	Integer updateByEmail(@Param("bean") T t, @Param("email")String email); 

	/**
 	 * 根据 Email 删除
 	 */
	Integer deleteByEmail(@Param("email")String email);

}