package com.ssm.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.entity.BasicUser;
import com.ssm.service.BasicUserService;
import com.ssm.util.EncryptKit;
import com.ssm.util.ResultModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户控制器
 * @author https://blog.csdn.net/caiqing116
 * http://192.168.100.104:7080/SSM_DEMO/static/swagger/index.html
 */
@RestController
@RequestMapping("/ssm/rest/basicUser")
@Api(tags="用户管理接口文档")
public class BasicUserRestController {
	
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
	@ApiOperation(value="新增用户信息", httpMethod="POST", response=ResultModel.class)
	public ResultModel insertBasicUser(BasicUser basicUser) {
		basicUser.setPassword(EncryptKit.MD5(basicUser.getPassword()));
		int row = basicUserService.insert(basicUser);
		if(row > 0) {
			return new ResultModel(201, row, "新增成功");
		}
		return new ResultModel(200, row, "新增失败");
	}
	
	/**
	 * 删
	 * @param id 用户id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value="删除用户信息", httpMethod="DELETE", response=ResultModel.class)
	public ResultModel deleteById(@PathVariable("id")Integer id) {
		int row = basicUserService.deleteById(id);
		if(row > 0) {
			return new ResultModel(201, row, "删除成功");
		}
		return new ResultModel(404, row, "删除失败");
	}
	
	/**
	 * 查
	 * @param id 用户id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ApiOperation(value="获取用户信息", httpMethod="GET", response=ResultModel.class)
	public ResultModel selectById(@PathVariable("id")Integer id) {
		BasicUser basicUser = basicUserService.selectById(id);
		return new ResultModel(200, basicUser, "获取成功");
	}
	
	/**
	 * 改
	 * @param id 用户id
	 * @param realname 用户真实姓名
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ApiOperation(value="修改用户信息", httpMethod="PUT", response=ResultModel.class)
	public Object updateById(@PathVariable("id")Integer id, 
			@ApiParam(value="真实姓名", required=true, name="realname")@RequestParam(value="realname") String realname) {
		BasicUser basicUser = new BasicUser();
		basicUser.setId(id);
		basicUser.setRealname(realname);
		int row =  basicUserService.updateById(basicUser);
		if(row > 0) {
			return new ResultModel(201, row, "更新成功");
		}
		return new ResultModel(200, row, "更新失败");
	}

}
