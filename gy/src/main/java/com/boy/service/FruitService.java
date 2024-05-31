package com.boy.service;

import com.boy.domain.Fruit;
import com.boy.domain.bo.FruitPagingToGetDataBo;
import com.boy.domain.vo.ResponseVo;

public interface FruitService{

    ResponseVo deleteByPrimaryKey(Long id);


    ResponseVo insertSelective(Fruit record);

    ResponseVo selectByPrimaryKey(Long id);

    ResponseVo updateByPrimaryKeySelective(Fruit record);


//    ResponseVo queryByPage(FruitPagingToGetDataBo );
}
