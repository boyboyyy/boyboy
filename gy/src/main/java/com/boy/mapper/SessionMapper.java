package com.boy.mapper;

import com.boy.domain.Session;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Session record);

    List<Session> selectAll();

}
