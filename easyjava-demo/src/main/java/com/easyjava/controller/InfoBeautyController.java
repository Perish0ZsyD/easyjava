package com.easyjava.controller;


import java.util.List;
import com.easyjava.service.InfoBeautyService;
import com.easyjava.entity.vo.ResponseVO;
import com.easyjava.entity.po.InfoBeauty;
import com.easyjava.entity.query.InfoBeautyQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/**
 * @Description: 靓号表 Controller
 * @Author: false
 * @Date: 2024/11/08 14:52:20
 */
@RestController
@RequestMapping("/infoBeauty")
public class InfoBeautyController extends ABaseController{

	@Resource
	private InfoBeautyService infoBeautyService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(InfoBeautyQuery query) {
		return getSuccessResponseVO(infoBeautyService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(InfoBeauty bean) {
		Integer result = this.infoBeautyService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<InfoBeauty> listBean) {
		this.infoBeautyService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<InfoBeauty> listBean) {
		this.infoBeautyService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@RequestMapping("/getInfoBeautyById")
	public ResponseVO getInfoBeautyById(String id) {
		return getSuccessResponseVO(infoBeautyService.getInfoBeautyById(id));}

	/**
 	 * 根据 Id 更新
 	 */
	@RequestMapping("/updateInfoBeautyById")
	public ResponseVO updateInfoBeautyById(InfoBeauty bean, String id) {
		this.infoBeautyService.updateInfoBeautyById(bean, id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 Id 删除
 	 */
	@RequestMapping("/deleteInfoBeautyById")
	public ResponseVO deleteInfoBeautyById(String id) {
		this.infoBeautyService.deleteInfoBeautyById(id);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@RequestMapping("/getInfoBeautyByUserIdAndEmail")
	public ResponseVO getInfoBeautyByUserIdAndEmail(String userId, String email) {
		return getSuccessResponseVO(infoBeautyService.getInfoBeautyByUserIdAndEmail(userId, email));}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@RequestMapping("/updateInfoBeautyByUserIdAndEmail")
	public ResponseVO updateInfoBeautyByUserIdAndEmail(InfoBeauty bean, String userId, String email) {
		this.infoBeautyService.updateInfoBeautyByUserIdAndEmail(bean, userId, email);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@RequestMapping("/deleteInfoBeautyByUserIdAndEmail")
	public ResponseVO deleteInfoBeautyByUserIdAndEmail(String userId, String email) {
		this.infoBeautyService.deleteInfoBeautyByUserIdAndEmail(userId, email);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 查询
 	 */
	@RequestMapping("/getInfoBeautyByUserIdAndEmail")
	public ResponseVO getInfoBeautyByUserIdAndEmail(String userId, String email) {
		return getSuccessResponseVO(infoBeautyService.getInfoBeautyByUserIdAndEmail(userId, email));}

	/**
 	 * 根据 UserIdAndEmail 更新
 	 */
	@RequestMapping("/updateInfoBeautyByUserIdAndEmail")
	public ResponseVO updateInfoBeautyByUserIdAndEmail(InfoBeauty bean, String userId, String email) {
		this.infoBeautyService.updateInfoBeautyByUserIdAndEmail(bean, userId, email);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 UserIdAndEmail 删除
 	 */
	@RequestMapping("/deleteInfoBeautyByUserIdAndEmail")
	public ResponseVO deleteInfoBeautyByUserIdAndEmail(String userId, String email) {
		this.infoBeautyService.deleteInfoBeautyByUserIdAndEmail(userId, email);
		return getSuccessResponseVO(null);
}
}