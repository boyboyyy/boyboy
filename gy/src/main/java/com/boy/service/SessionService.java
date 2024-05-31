package com.boy.service;

import com.boy.domain.Session;
import com.boy.domain.vo.ResponseVo;

public interface SessionService{

    ResponseVo deleteByPrimaryKey(Long id);

    ResponseVo insert(Session record);

    ResponseVo insertSelective(Session record);

    ResponseVo selectByPrimaryKey(Long id);

    ResponseVo updateByPrimaryKeySelective(Session record);


    ResponseVo selectAll();
}
