package com.boy.mapper;

import com.boy.domain.Session;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Session record);

}
