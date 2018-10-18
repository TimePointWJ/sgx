package com.jtzh.service;

import com.jtzh.entity.UnionPhoneBook;
import com.jtzh.entity.UnionUser;
import com.jtzh.pojo.PhoneBookParam;

public interface PhoneBookService {

	public Object getBook(UnionUser user,PhoneBookParam param);
	
	public Object insertBook(UnionUser user,UnionPhoneBook book);
	
	public int  removeBook(String id);
	
	public Object updateBook(UnionPhoneBook book);
}
