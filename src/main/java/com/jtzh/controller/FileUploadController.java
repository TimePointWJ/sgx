package com.jtzh.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jtzh.common.ResultObject;

@RestController
@RequestMapping("file")
public class FileUploadController {
    /**
	 * 实现文件上传
	 */
    @RequestMapping("fileUpload")
    public Object fileUpload(HttpServletRequest request){
    	String id = request.getParameter("id");
    	MultipartFile file = ((MultipartHttpServletRequest)request).getFile(id);
    	String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
    	String fileName = request.getParameter("fileName");
        if(file.isEmpty()){
            return "false";
        }
        String path = "D:/ynw" ;
        if(!StringUtils.isNotBlank(fileName)) {
        	fileName = String.valueOf(new Date().getTime())+"."+suffix;
        }
        File dest = new File(path + "/" + fileName);
		if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        ResultObject obj = new ResultObject();
        try {
			file.transferTo(dest); // 保存文件
            obj.setResult(true);
            obj.setObj(fileName);
            return obj;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            obj.setResult(false);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            obj.setResult(false);
            return obj;
        }
    }

    @RequestMapping(value="multifileUpload",method=RequestMethod.POST)
	public Object multifileUpload(HttpServletRequest request) {

        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("fileName");
		ResultObject obj = new ResultObject();
        if(files.isEmpty()){
			obj.setResult(false);
        }

        String path = "D:/test" ;
		List<String> list = new ArrayList<String>();
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();

            if(file.isEmpty()){
				obj.setResult(false);
            }else{
                File dest = new File(path + "/" + fileName);
				if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
					obj.setResult(true);
					list.add(fileName);
					obj.setObj(list);
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
					obj.setResult(false);
                }
            }
        }
		return obj;
    }
}

