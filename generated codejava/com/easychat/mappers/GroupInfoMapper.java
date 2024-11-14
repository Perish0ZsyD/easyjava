package com.easychat.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * @Description:  Mapper
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
public interface GroupInfoMapper<T, P> extends BaseMapper {

	/**
 	 * 根据 GroupId 查询
 	 */
	T selectByGroupId(@Param("groupId")String groupId);

	/**
 	 * 根据 GroupId 更新
 	 */
	Integer updateByGroupId(@Param("bean") T t, @Param("groupId")String groupId); 

	/**
 	 * 根据 GroupId 删除
 	 */
	Integer deleteByGroupId(@Param("groupId")String groupId);

}