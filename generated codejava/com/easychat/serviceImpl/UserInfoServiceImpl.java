package com.easychat.serviceImpl;


import java.util.List;
import com.easychat.entity.query.SimplePage;
import com.easychat.enums.PageSize;
import com.easychat.mappers.UserInfoMapper;
import com.easychat.service.UserInfoService;
import com.easychat.entity.vo.PaginationResultVO;
import com.easychat.entity.po.UserInfo;
import com.easychat.entity.query.UserInfoQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description: 用户信息表 业务接口实现
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
@Service("UserInfoMapper")
public class UserInfoServiceImpl implements UserInfoService{

	@Resource
	private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<UserInfo> findListByParam(UserInfoQuery query) {
		return this.userInfoMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(UserInfoQuery query) {
		return this.userInfoMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<UserInfo> findListByPage(UserInfoQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<UserInfo> list = this.findListByParam(query);
		PaginationResultVO<UserInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(UserInfo bean) {
		return this.userInfoMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<UserInfo> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.userInfoMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<UserInfo> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.userInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 UserId 查询
 	 */
	@Override
	public UserInfo getUserInfoByUserId(String userId) {
		return this.userInfoMapper.selectByUserId(userId);}

	/**
 	 * 根据 UserId 更新
 	 */
	@Override
	public Integer updateUserInfoByUserId(UserInfo bean, String userId) {
		return this.userInfoMapper.updateByUserId(bean, userId);}

	/**
 	 * 根据 UserId 删除
 	 */
	@Override
	public Integer deleteUserInfoByUserId(String userId) {
		return this.userInfoMapper.deleteByUserId(userId);}

	/**
 	 * 根据 Email 查询
 	 */
	@Override
	public UserInfo getUserInfoByEmail(String email) {
		return this.userInfoMapper.selectByEmail(email);}

	/**
 	 * 根据 Email 更新
 	 */
	@Override
	public Integer updateUserInfoByEmail(UserInfo bean, String email) {
		return this.userInfoMapper.updateByEmail(bean, email);}

	/**
 	 * 根据 Email 删除
 	 */
	@Override
	public Integer deleteUserInfoByEmail(String email) {
		return this.userInfoMapper.deleteByEmail(email);}

	/**
 	 * 根据 Email 查询
 	 */
	@Override
	public UserInfo getUserInfoByEmail(String email) {
		return this.userInfoMapper.selectByEmail(email);}

	/**
 	 * 根据 Email 更新
 	 */
	@Override
	public Integer updateUserInfoByEmail(UserInfo bean, String email) {
		return this.userInfoMapper.updateByEmail(bean, email);}

	/**
 	 * 根据 Email 删除
 	 */
	@Override
	public Integer deleteUserInfoByEmail(String email) {
		return this.userInfoMapper.deleteByEmail(email);}
}