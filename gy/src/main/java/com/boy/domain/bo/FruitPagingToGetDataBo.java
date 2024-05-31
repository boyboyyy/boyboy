package com.boy.domain.bo;

import com.boy.domain.Fruit;

import java.io.Serializable;

public class FruitPagingToGetDataBo implements Serializable {

    private Long start;//开始坐标
    private Integer size;//每页显示长度
    private Fruit fruit;

    public FruitPagingToGetDataBo() {
    }

    public FruitPagingToGetDataBo(Long start, Integer size, Fruit fruit) {
        this.start = start;
        this.size = size;
        this.fruit = fruit;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "FruitPagingToGetDataBo{" +
                "start=" + start +
                ", size=" + size +
                ", fruit=" + fruit +
                '}';
    }
}
