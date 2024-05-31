package com.boy.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.boy.domain.Session;
import com.boy.mapper.SessionMapper;
import com.boy.service.SessionService;
@Service
public class SessionServiceImpl implements SessionService{

    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sessionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Session record) {
        return sessionMapper.insert(record);
    }

    @Override
    public int insertSelective(Session record) {
        return sessionMapper.insertSelective(record);
    }

    @Override
    public Session selectByPrimaryKey(Long id) {
        return sessionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Session record) {
        return sessionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Session record) {
        return sessionMapper.updateByPrimaryKey(record);
    }

}
