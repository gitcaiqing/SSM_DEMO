package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.BasicUser;
import com.ssm.entity.Page;
import com.ssm.service.BasicUserService;
import com.ssm.util.FinalData;
import com.ssm.util.ResultModel;

/**
 * 用户控制器
 * @author https://blog.csdn.net/caiqing116
 */
@Controller
@RequestMapping("/ssm/basicUser")
public class BasicUserController {
	
	@Autowired 
	private BasicUserService basicUserService;

	/**
	 * GET    --> /ssm/basicUser/1            查看某个具体的用户
	 * POST   --> /ssm/basicUser/user  新建一个用户
	 * PUT    --> /ssm/basicUser/1            更新某个具体的用户
	 * DELETE --> /ssm/basicUser/1            删除某个具体的用户
	*/
	
	/**
	 * 增
	 * @param basicUser 用户对象
	 * @return
	 */
	@RequestMapping(value="/user", method = RequestMethod.POST)
	@ResponseBody
	public ResultModel insertBasicUser(BasicUser basicUser) {
		int row = basicUserService.insert(basicUser);
		if(row > 0) {
			return new ResultModel(FinalData.SUCCESS, row, "新增成功");
		}
		return new ResultModel(1, row, "新增失败");
	}
	
	/**
	 * 删
	 * @param id 用户id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultModel deleteById(@PathVariable("id")Integer id) {
		int row = basicUserService.deleteById(id);
		if(row > 0) {
			return new ResultModel(0, row, "新增成功");
		}
		return new ResultModel(1, row, "新增失败");
	}
	
	/**
	 * 查
	 * @param id 用户id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultModel selectById(@PathVariable("id")Integer id) {
		BasicUser basicUser = basicUserService.selectById(id);
		return new ResultModel(0, basicUser, "获取成功");
	}
	
	
	/**
	 * 改
	 * @param id 用户id
	 * @param realname 用户真实姓名
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateById(@PathVariable("id")Integer id, String realname) {
		BasicUser basicUser = new BasicUser();
		basicUser.setId(id);
		basicUser.setRealname(realname);
		return basicUserService.updateById(basicUser);
	}
	
	@RequestMapping("/listPage")
	public String listBasicUser() {
		return "/basicUser/list";
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	@ResponseBody
	public Object users(BasicUser basicUser, Page<BasicUser> page) {
		return basicUserService.listBasicUser(basicUser, page);
	}
}
