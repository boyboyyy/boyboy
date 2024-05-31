package com.boy.service;

import com.boy.domain.Session;
public interface SessionService{

    int deleteByPrimaryKey(Long id);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);

}
