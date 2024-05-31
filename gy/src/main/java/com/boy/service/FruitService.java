package com.boy.service;

import com.boy.domain.Fruit;
public interface FruitService{

    int deleteByPrimaryKey(Long id);

    int insert(Fruit record);

    int insertSelective(Fruit record);

    Fruit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Fruit record);


}
