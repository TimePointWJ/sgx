package com.jtzh.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtzh.common.ResultObject;
import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionPhoneBook;
import com.jtzh.entity.UnionUser;
import com.jtzh.mapper.UnionPhoneBookMapper;
import com.jtzh.pojo.PhoneBookParam;
@Service("phoneBookService")
public class PhoneBookServiceImpl implements PhoneBookService {

	@Resource
	private UnionPhoneBookMapper unionPhoneBookMapper;
	@Override
	public Object getBook(UnionUser user, PhoneBookParam param) {
		Page page = new Page();
        page.setCurrPage(param.getPage());
        page.setPageSize(param.getPageSize());
        page.setParam(param);
        
		int total = unionPhoneBookMapper.selectBookTotal(page);
		if(total >0) {
			List<UnionPhoneBook> book = unionPhoneBookMapper.selectBook(page);
			page.setData(book);
			page.setTotal(total);
        }
		return page;
	}
	@Override
	public Object insertBook(UnionUser user, UnionPhoneBook book) {
		book.setCreateId(user.getLoginId());
		book.setCreateTime(new Date());
		book.setDelflag("A");
		unionPhoneBookMapper.insertBook(book);
		return new ResultObject();
	}
	@Override
	public int removeBook(String id) {
		
		return unionPhoneBookMapper.delectBook(id);
	}
	@Override
	public Object updateBook(UnionPhoneBook book) {
		unionPhoneBookMapper.updateBook(book);
		return new ResultObject();
	}

}
