package com.easyjava.service.impl;


import java.util.List;
import com.easyjava.entity.query.SimplePage;
import com.easyjava.enums.PageSize;
import com.easyjava.mappers.InfoBeautyMapper;
import com.easyjava.service.InfoBeautyService;
import com.easyjava.entity.vo.PaginationResultVO;
import com.easyjava.entity.po.InfoBeauty;
import com.easyjava.entity.query.InfoBeautyQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description: 靓号表 业务接口实现
 * @Author: false
 * @Date: 2024/11/06 18:47:59
 */
@Service("InfoBeautyMapper")
public class InfoBeautyServiceImpl implements InfoBeautyService{

	@Resource
	private InfoBeautyMapper<InfoBeauty, InfoBeautyQuery> infoBeautyMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<InfoBeauty> findListByParam(InfoBeautyQuery query) {
		return this.infoBeautyMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(InfoBeautyQuery query) {
		return this.infoBeautyMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<InfoBeauty> findListByPage(InfoBeautyQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<InfoBeauty> list = this.findListByParam(query);
		PaginationResultVO<InfoBeauty> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(InfoBeauty bean) {
		return this.infoBeautyMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<InfoBeauty> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.infoBeautyMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<InfoBeauty> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.infoBeautyMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public InfoBeauty getInfoBeautyById(String id) {
		return this.infoBeautyMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateInfoBeautyById(InfoBeauty bean, String id) {
		return this.infoBeautyMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteInfoBeautyById(String id) {
		return this.infoBeautyMapper.deleteById(id);}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@Override
	public InfoBeauty getInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.infoBeautyMapper.selectByUserIdAndEmail(userId, email);}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@Override
	public Integer updateInfoBeautyByUserIdAndEmail(InfoBeauty bean, String userId, String email) {
		return this.infoBeautyMapper.updateByUserIdAndEmail(bean, userId, email);}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@Override
	public Integer deleteInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.infoBeautyMapper.deleteByUserIdAndEmail(userId, email);}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@Override
	public InfoBeauty getInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.infoBeautyMapper.selectByUserIdAndEmail(userId, email);}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@Override
	public Integer updateInfoBeautyByUserIdAndEmail(InfoBeauty bean, String userId, String email) {
		return this.infoBeautyMapper.updateByUserIdAndEmail(bean, userId, email);}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@Override
	public Integer deleteInfoBeautyByUserIdAndEmail(String userId, String email) {
		return this.infoBeautyMapper.deleteByUserIdAndEmail(userId, email);}
}