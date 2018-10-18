package com.jtzh.service;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.page.Page;
import com.jtzh.common.util.ExcelUtil;
import com.jtzh.entity.UnionUnion;
import com.jtzh.entity.UnionUser;
import com.jtzh.mapper.UnionUnionMapper;
import com.jtzh.mapper.UnionUserMapper;
import com.jtzh.pojo.UserParam;
import com.jtzh.pojo.UserPassword;

@Service("unionUserService")
public class UnionUserServiceIpl implements UnionUserService {

	protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(UnionUserService.class);
	@Resource
	private UnionUnionMapper unitMapper;
	@Resource
	private UnionUserMapper unionUserMapper;
	@Override
	public Object getUser(HttpServletRequest request,UnionUser user) {
		UnionUser unionUser =unionUserMapper.getUser(user.getLoginId());
		ResultObject object =  new ResultObject();
		object.setResult(false);
		if(unionUser !=null &&  user.getPassword().equals(unionUser.getPassword())){
			request.getSession().setAttribute("user",unionUser);
			request.getSession().setMaxInactiveInterval(-1);
			logger.info(unionUser.getLoginId() + "登陆成功");
			object.setResult(true);
            unionUser.setPassword("");
            unionUser.setSessionId(request.getSession().getId());
            object.setObj(unionUser);
		}
		return object;
	}
	@Override
	public Object updateUser(UnionUser user) {
		ResultObject object = new ResultObject();
		UnionUser exUser = unionUserMapper.getUser(user.getLoginId());
		if (exUser == null) {
			object.setMessage("手机号异常");
			return object;
		}
		UnionUnion unit = unitMapper.getUnitByName(user.getUnion());
		if (unit == null) {
			object.setMessage("单位异常");
			return object;
		}
		exUser.setUnionId(String.valueOf(unit.getId()));
		exUser.setHigherUnion(unit.getSuperiorUnionName());
		exUser.setHigherUnionId(String.valueOf(unit.getSuperiorUnionId()));
		exUser.setUserName(user.getUserName());
		exUser.setLoginId(user.getLoginId());
		exUser.setEmail(user.getEmail());
		exUser.setIdentity(user.getIdentity());
		exUser.setUnion(user.getUnion());
		exUser.setJob(user.getJob());
		// exUser.setHigherUnion(user.getHigherUnion());
		unionUserMapper.updateUser(exUser);
        return object;	
	}
	@Override
	public Object changePassword(UserPassword userPassword) {
		UnionUser exUser = unionUserMapper.getUser(userPassword.getLoginId());
		ResultObject object =  new ResultObject();
		if (exUser.getPassword().equals(userPassword.getOldPassword())) {
			object.setMessage("旧密码核对成功");
				exUser.setPassword(userPassword.getNewPassword());
				unionUserMapper.updateUser(exUser);
			return object;
		}
		return object;
	}

	@Override
	public Object getUserList(UserParam param) {
		Page page = new Page();
		page.setCurrPage(param.getPage());
		page.setPageSize(param.getPageSize());
		page.setParam(param);
		int total = unionUserMapper.selectTotal(page);
		if (total > 0) {
			List<UnionUser> list = unionUserMapper.selectUserList(page);
			page.setTotal(total);
			page.setData(list);
		}
		return page;
	}

	@Override
	public Object insertUser(UnionUser param) {
		param.setDelflag("A");
		param.setCreatTime(new Date());
		param.setPassword("123456");
		UnionUnion unit = unitMapper.getUnitByName(param.getUnion());
		param.setUnionId(String.valueOf(unit.getId()));
		param.setHigherUnion(unit.getSuperiorUnionName());
		param.setHigherUnionId(String.valueOf(unit.getSuperiorUnionId()));
		// param.set
		unionUserMapper.insert(param);
		return new ResultObject();
	}

	@Override
	public Object deleteUser(String id) {
		unionUserMapper.deleteUser(id);
		return new ResultObject();
	}

	@Override
	public Object exportExcel(HttpServletResponse response) {
		// 获取数据
		List<UnionUser> list = unionUserMapper.getUserList();
		// excel标题
		String[] title = { "序号", "用户名称", "职务", "角色", "创建时间" };
		// excel文件名
		String fileName = "用户表" + System.currentTimeMillis() + ".xls";
		// sheet名
		String sheetName = "用户信息表";
		String[][] content = new String[list.size()][title.length];
		for (int i = 0; i < list.size(); i++) {
			UnionUser user = list.get(i);
			//content[i] = new String[title.length];
			content[i][0] = String.valueOf(i + 1);
			content[i][1] = user.getUserName();
			content[i][2] = user.getJob();
			if ("1".equals(user.getAccess())) {
				content[i][3] = "工会成员";
			}
			if ("2".equals(user.getAccess())) {
				content[i][3] = "办公室";
			}
			if ("3".equals(user.getAccess())) {
				content[i][3] = "分管领导";
			}
			if ("4".equals(user.getAccess())) {
				content[i][3] = "主要领导";
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = df.format(user.getCreatTime());
			content[i][4] = date;
		}
		// 创建HSSFWorkbook
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
		// 响应到客户端
		try {
			this.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultObject();
	}

	// 发送响应流方法
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
