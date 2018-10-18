package com.jtzh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.ResultObject;
import com.jtzh.common.base.BaseController;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.UserParam;
import com.jtzh.pojo.UserPassword;
import com.jtzh.service.UnionUserService;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
	protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UnionUserService unionUserService;
    @RequestMapping(value= "/login", method = RequestMethod.POST)
    public Object login(HttpServletResponse response, HttpServletRequest request,@RequestBody UnionUser user){
        if(user.getLoginId()!= null && user.getPassword() !=null){
            return unionUserService.getUser(request,user);
        }
        ResultObject obj = new ResultObject();
        obj.setResult(false);
        return obj;
    }
    @RequestMapping(value= "/update", method = RequestMethod.POST)
    public Object update(HttpServletResponse response, HttpServletRequest request,@RequestBody UnionUser user){
		// UnionUser exUser = getUserInfo(request);
		return unionUserService.updateUser(user);
    }
    @RequestMapping(value= "/changePassword", method = RequestMethod.POST)
    public Object changePassword(HttpServletResponse response, HttpServletRequest request,@RequestBody UserPassword userPassword){
		// UnionUser exUser = getUserInfo(request);
		return unionUserService.changePassword(userPassword);
	}

	/**
	 * 默认获取用户api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	public Object getLawList(@RequestBody UserParam param) {
		return unionUserService.getUserList(param);
	}

	/**
	 * 新建用户api
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public Object addUser(@RequestBody UnionUser param) {
		return unionUserService.insertUser(param);
	}

	/**
	 * 修改用户api
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public Object updateUser(@RequestBody UnionUser param) {
		return unionUserService.updateUser(param);
	}

	@RequestMapping(value = "deleteUser/{id}", method = RequestMethod.GET)
	public Object deleteUser(@PathVariable("id") String id) {
		unionUserService.deleteUser(id);
		return new ResultObject();

	}

	/**
	 * 导出员工excel
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public Object export(HttpServletRequest request, HttpServletResponse response) {
		unionUserService.exportExcel(response);
		return null;
	}
}
