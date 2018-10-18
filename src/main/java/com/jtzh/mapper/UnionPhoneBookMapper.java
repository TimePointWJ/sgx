package com.jtzh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionPhoneBook;

public interface UnionPhoneBookMapper {

	List<UnionPhoneBook> selectBook(@Param("page")Page page);//
	
	int selectBookTotal(@Param("page")Page page);//

    int insertBook(UnionPhoneBook record);
    
    int delectBook(@Param("id")String id);
    
    void updateBook(UnionPhoneBook record);

}