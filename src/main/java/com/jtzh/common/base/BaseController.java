package com.jtzh.common.base;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jtzh.common.Response;
import com.jtzh.common.exception.LogicException;
import com.jtzh.common.util.ResUtil;
import com.jtzh.entity.UnionUser;


@ControllerAdvice(annotations = RestController.class)
public class BaseController {
    @ExceptionHandler
    @ResponseBody
    public Response handleException(Exception e) {
        if (e.getClass().getName().equals(HttpMessageConversionException.class.getName())) {
            return ResUtil.paramError(e.toString());
        }
        if (e instanceof LogicException) {
            return ResUtil.logicError(e.getMessage());
        }
        return ResUtil.systemError(e.toString().substring(e.toString().indexOf(":") + 1));
    }
    
    public UnionUser getUserInfo(HttpServletRequest request) {
		UnionUser user = new UnionUser();
		user.setAccess("1");
		user.setHigherUnion("2");
		user.setHigherUnionId("2");
		user.setLoginId("13888888888");
		user.setUnionId("1");
		user.setUserName("111");
		user.setId("1");
		user.setPassword("123456");
		return user;
		// return (UnionUser) request.getSession().getAttribute("user");
    	
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
