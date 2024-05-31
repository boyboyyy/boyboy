package com.boy.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.boy.domain.Fruit;
import com.boy.mapper.FruitMapper;
import com.boy.service.FruitService;
@Service
public class FruitServiceImpl implements FruitService{

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return fruitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Fruit record) {
        return fruitMapper.insert(record);
    }

    @Override
    public int insertSelective(Fruit record) {
        return fruitMapper.insertSelective(record);
    }

    @Override
    public Fruit selectByPrimaryKey(Long id) {
        return fruitMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Fruit record) {
        return fruitMapper.updateByPrimaryKeySelective(record);
    }



}
