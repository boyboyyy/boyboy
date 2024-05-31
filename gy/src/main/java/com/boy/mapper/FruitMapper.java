package com.boy.mapper;

import com.boy.domain.Fruit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FruitMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Fruit record);

    Fruit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Fruit record);

 }
