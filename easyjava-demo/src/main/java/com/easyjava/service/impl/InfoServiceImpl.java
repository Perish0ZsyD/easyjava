package com.easyjava.service.impl;


import java.util.List;
import com.easyjava.entity.query.SimplePage;
import com.easyjava.enums.PageSize;
import com.easyjava.mappers.InfoMapper;
import com.easyjava.service.InfoService;
import com.easyjava.entity.vo.PaginationResultVO;
import com.easyjava.entity.po.Info;
import com.easyjava.entity.query.InfoQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description: 用户信息表 业务接口实现
 * @Author: false
 * @Date: 2024/11/06 18:47:59
 */
@Service("InfoMapper")
public class InfoServiceImpl implements InfoService{

	@Resource
	private InfoMapper<Info, InfoQuery> infoMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<Info> findListByParam(InfoQuery query) {
		return this.infoMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(InfoQuery query) {
		return this.infoMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<Info> findListByPage(InfoQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Info> list = this.findListByParam(query);
		PaginationResultVO<Info> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(Info bean) {
		return this.infoMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<Info> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.infoMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<Info> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.infoMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 UserId 查询
 	 */
	@Override
	public Info getInfoByUserId(String userId) {
		return this.infoMapper.selectByUserId(userId);}

	/**
 	 * 根据 UserId 更新
 	 */
	@Override
	public Integer updateInfoByUserId(Info bean, String userId) {
		return this.infoMapper.updateByUserId(bean, userId);}

	/**
 	 * 根据 UserId 删除
 	 */
	@Override
	public Integer deleteInfoByUserId(String userId) {
		return this.infoMapper.deleteByUserId(userId);}

	/**
 	 * 根据 Email 查询
 	 */
	@Override
	public Info getInfoByEmail(String email) {
		return this.infoMapper.selectByEmail(email);}

	/**
 	 * 根据 Email 更新
 	 */
	@Override
	public Integer updateInfoByEmail(Info bean, String email) {
		return this.infoMapper.updateByEmail(bean, email);}

	/**
 	 * 根据 Email 删除
 	 */
	@Override
	public Integer deleteInfoByEmail(String email) {
		return this.infoMapper.deleteByEmail(email);}

	/**
 	 * 根据 Email 查询
 	 */
	@Override
	public Info getInfoByEmail(String email) {
		return this.infoMapper.selectByEmail(email);}

	/**
 	 * 根据 Email 更新
 	 */
	@Override
	public Integer updateInfoByEmail(Info bean, String email) {
		return this.infoMapper.updateByEmail(bean, email);}

	/**
 	 * 根据 Email 删除
 	 */
	@Override
	public Integer deleteInfoByEmail(String email) {
		return this.infoMapper.deleteByEmail(email);}
}