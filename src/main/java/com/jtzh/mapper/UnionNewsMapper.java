package com.jtzh.mapper;



import com.jtzh.common.page.Page;
import com.jtzh.entity.UnionNews;
import com.jtzh.pojo.ViewNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UnionNewsMapper {
    
    List<UnionNews> selectNews(@Param("page") Page page);//
    
    int selectNewsCount(@Param("page") Page page);//
    
    ViewNews selectNewsInfo(@Param("id") String id);//

    boolean removeNew(@Param("id")String id);
    
    boolean insertNews(ViewNews viewNews);
    
    boolean updateNews(ViewNews viewNews);

}