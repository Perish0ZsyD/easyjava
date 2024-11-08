package com.easychat.serviceImpl;


import java.util.List;
import com.easychat.entity.query.SimplePage;
import com.easychat.enums.PageSize;
import com.easychat.mappers.UserInfoBeautyMapper;
import com.easychat.service.UserInfoBeautyService;
import com.easychat.entity.vo.PaginationResultVO;
import com.easychat.entity.po.UserInfoBeauty;
import com.easychat.entity.query.UserInfoBeautyQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description: 靓号表 业务接口实现
 * @Author: false
 * @Date: 2024/11/08 19:02:56
 */
@Service("UserInfoBeautyMapper")
public class UserInfoBeautyServiceImpl implements UserInfoBeautyService{

	@Resource
	private UserInfoBeautyMapper<UserInfoBeauty, UserInfoBeautyQuery> userInfoBeautyMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<UserInfoBeauty> findListByParam(UserInfoBeautyQuery query) {
		return this.userInfoBeautyMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(UserInfoBeautyQuery query) {
		return this.userInfoBeautyMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<UserInfoBeauty> findListByPage(UserInfoBeautyQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<UserInfoBeauty> list = this.findListByParam(query);
		PaginationResultVO<UserInfoBeauty> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(UserInfoBeauty bean) {
		return this.userInfoBeautyMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<UserInfoBeauty> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.userInfoBeautyMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<UserInfoBeauty> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.userInfoBeautyMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public UserInfoBeauty getUserInfoBeautyById(String id) {
		return this.userInfoBeautyMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateUserInfoBeautyById(UserInfoBeauty bean, String id) {
		return this.userInfoBeautyMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteUserInfoBeautyById(String id) {
		return this.userInfoBeautyMapper.deleteById(id);}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@Override
	public UserInfoBeauty getUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.userInfoBeautyMapper.selectByUserIdAndEmail(userId, email);}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@Override
	public Integer updateUserInfoBeautyByUserIdAndEmail(UserInfoBeauty bean, String userId, String email) {
		return this.userInfoBeautyMapper.updateByUserIdAndEmail(bean, userId, email);}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@Override
	public Integer deleteUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.userInfoBeautyMapper.deleteByUserIdAndEmail(userId, email);}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@Override
	public UserInfoBeauty getUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.userInfoBeautyMapper.selectByUserIdAndEmail(userId, email);}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@Override
	public Integer updateUserInfoBeautyByUserIdAndEmail(UserInfoBeauty bean, String userId, String email) {
		return this.userInfoBeautyMapper.updateByUserIdAndEmail(bean, userId, email);}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@Override
	public Integer deleteUserInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.userInfoBeautyMapper.deleteByUserIdAndEmail(userId, email);}
}