package com.jtzh.mapper;



import com.jtzh.entity.UnionSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UnionSourceMapper {

    List<UnionSource> selectSource(@Param("source") String source, @Param("id") String id);//

    boolean removeSource(@Param("type")String type,@Param("newsId")String newsId);
    
    boolean insertSource(UnionSource source);
    

}