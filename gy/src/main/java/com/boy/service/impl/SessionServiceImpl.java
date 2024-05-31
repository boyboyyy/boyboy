package com.boy.service.impl;

import com.boy.domain.Fruit;
import com.boy.domain.vo.ResponseVo;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.boy.domain.Session;
import com.boy.mapper.SessionMapper;
import com.boy.service.SessionService;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{

    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public ResponseVo deleteByPrimaryKey(Long id) {
       boolean b = sessionMapper.deleteByPrimaryKey(id) > 0;

        if (!b){
            new ResponseVo("删除失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("删除成功", null,"0x200");
    }

    @Override
    public ResponseVo insert(Session record) {

        System.out.println(record);

        int insert = sessionMapper.insert(record);

        if (insert == 0){
            new ResponseVo("添加失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("添加成功", null,"0x200");

    }

    @Override
    public ResponseVo insertSelective(Session record) {

        int insert = sessionMapper.insertSelective(record);

        if (insert == 0){
            new ResponseVo("添加失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("添加成功", null,"0x200");
    }

    @Override
    public ResponseVo selectByPrimaryKey(Long id) {

        Session session = sessionMapper.selectByPrimaryKey(id);

        if (session == null){
            return new ResponseVo("查询失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("查询成功", session,"0x200");
    }

    @Override
    public ResponseVo updateByPrimaryKeySelective(Session record) {

        int update = sessionMapper.updateByPrimaryKeySelective(record);

        if (update == 0){
            new ResponseVo("修改失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("修改成功", null,"0x200");

    }


    @Override
    public ResponseVo selectAll() {

        List<Session> sessionList = sessionMapper.selectAll();
        System.out.println(sessionList);
        if (sessionList == null || sessionList.size() == 0){
            new ResponseVo("查询失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("查询成功", sessionList,"0x200");
    }

}
