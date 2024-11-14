package com.easychat.controller;


import java.util.List;
import com.easychat.service.GroupInfoService;
import com.easychat.entity.vo.ResponseVO;
import com.easychat.entity.po.GroupInfo;
import com.easychat.entity.query.GroupInfoQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
/**
 * @Description:  Controller
 * @Author: false
 * @Date: 2024/11/14 23:06:48
 */
@RestController
@RequestMapping("/groupInfo")
public class GroupInfoController extends ABaseController{

	@Resource
	private GroupInfoService groupInfoService;

	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(GroupInfoQuery query) {
		return getSuccessResponseVO(groupInfoService.findListByPage(query));
	}

	/**
 	 * 新增
 	 */
	@RequestMapping("/add")
	public ResponseVO add(GroupInfo bean) {
		Integer result = this.groupInfoService.add(bean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增
 	 */
	@RequestMapping("/addBatch")
	public ResponseVO addBatch(@RequestBody List<GroupInfo> listBean) {
		this.groupInfoService.addBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 批量新增或修改
 	 */
	@RequestMapping("/addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<GroupInfo> listBean) {
		this.groupInfoService.addOrUpdateBatch(listBean);
		return getSuccessResponseVO(null);
	}

	/**
 	 * 根据 GroupId 查询
 	 */
	@RequestMapping("/getGroupInfoByGroupId")
	public ResponseVO getGroupInfoByGroupId(String groupId) {
		return getSuccessResponseVO(groupInfoService.getGroupInfoByGroupId(groupId));}

	/**
 	 * 根据 GroupId 更新
 	 */
	@RequestMapping("/updateGroupInfoByGroupId")
	public ResponseVO updateGroupInfoByGroupId(GroupInfo bean, String groupId) {
		this.groupInfoService.updateGroupInfoByGroupId(bean, groupId);
		return getSuccessResponseVO(null);
}

	/**
 	 * 根据 GroupId 删除
 	 */
	@RequestMapping("/deleteGroupInfoByGroupId")
	public ResponseVO deleteGroupInfoByGroupId(String groupId) {
		this.groupInfoService.deleteGroupInfoByGroupId(groupId);
		return getSuccessResponseVO(null);
}
}