package com.jtzh.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionForm;
import com.jtzh.entity.UnionSource;
import com.jtzh.entity.UnionUser;
import com.jtzh.mapper.UnionFormMapper;
import com.jtzh.mapper.UnionSourceMapper;
import com.jtzh.pojo.NewsParam;

@Service("formService")
public class FormServiceImpl implements FormService {

	@Resource
	private UnionFormMapper unionFormMapper;
	@Resource
	private UnionSourceMapper unionSourceMapper;
	@Override
	public Object getFormList(NewsParam newsParam) {
		Page page = new Page();
		page.setCurrPage(newsParam.getPage());
		page.setPageSize(newsParam.getPageSize());
		page.setParam(newsParam);
		int total = unionFormMapper.selectTotal(page);
		if(total>0) {
			List<UnionForm> list = unionFormMapper.selectFormList(page);
			page.setTotal(total);
			page.setData(list);
		}
		return page;
	}
	@Override
	public Object delectForm(String id) {
		return unionFormMapper.updateForm(id);
	}
	@Override
	public Object insertForm(UnionUser user, UnionForm unionForm) {
		unionForm.setCreateName(user.getUserName());
		unionForm.setCreateTime(new Date());
		unionForm.setDelflag("A");
		unionForm.setDownloadMun(0);
		unionForm.setFormUrl("D:\\ynw\\" + unionForm.getFormName());
		unionFormMapper.insertForm(unionForm);
		if (unionForm.getFormName() != null && unionForm.getFormName().length() != 0) {
			UnionSource source = new UnionSource();
			source.setCreatTime(new Date());
			source.setDelflag("A");
			source.setAttachmentSource("05");
			source.setSourceId(unionForm.getId());
			source.setFileName(unionForm.getFormName());
			source.setFileUrl("D:\\ynw\\" + unionForm.getFormName());
			unionSourceMapper.insertSource(source);
		}
		//return unionFormMapper.insertForm(unionForm);
		return new ResultObject();
	}
	@Override
	public Object updateForm(UnionForm unionForm) {
		unionForm.setFormUrl("D:\\ynw\\" + unionForm.getFormName());
		unionFormMapper.udateFormInfo(unionForm);
		// return unionFormMapper.udateFormInfo(unionForm);
		if (unionForm.getFormName() != null && unionForm.getFormName().length() != 0) {
			UnionSource source = new UnionSource();
			source.setCreatTime(new Date());
			source.setDelflag("A");
			source.setAttachmentSource("05");
			source.setSourceId(unionForm.getId());
			source.setFileName(unionForm.getFormName());
			source.setFileUrl("D:\\ynw\\" + unionForm.getFormName());
			unionSourceMapper.insertSource(source);
		}
		// return unionFormMapper.insertForm(unionForm);
		return new ResultObject();
	}

	@Override
	public Object updateNum(String id) {

		return unionFormMapper.updateNum(id);
	}

	/* 下载文件 */
	public void downloadService(HttpServletResponse res, Integer id) {
		UnionForm form = unionFormMapper.selectFormByPrimaryKey(id);
		String originPath = form.getFormUrl();
		File originFile = new File(originPath);
		String fileName = form.getFormName();
		unionFormMapper.updateNum(String.valueOf(id));
		res.reset();
		res.setContentType("application/octet-stream");
		// 设置文件名
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName); //
		byte[] buffer = new byte[1024];
		FileInputStream fis = null; // 文件输入流
		BufferedInputStream bis = null;
		OutputStream os = null; // 输出流
		try {
			os = res.getOutputStream();
			fis = new FileInputStream(originFile);
			bis = new BufferedInputStream(fis);
			int data;
			while ((data = bis.read(buffer)) != -1) {
				os.write(buffer, 0, data);
			}
			os.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
