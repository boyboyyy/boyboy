package com.boy.controller;

import com.alibaba.fastjson2.JSONArray;
import com.boy.domain.Fruit;
import com.boy.domain.bo.FruitPagingToGetDataBo;
import com.boy.service.FruitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Fruit)表控制层
 *
 * @author Oh...Yeah!!!
 * @since 2024-05-31 09:19:03
 */
@RestController
@RequestMapping(value = "fruit", produces = "text/plain;charset=UTF-8")
public class FruitController {
    /**
     * 服务对象
     */
    @Resource
    private FruitService fruitService;


    @GetMapping
    public String selectAll() {
        return JSONArray.toJSONString(fruitService.selectAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public String queryById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(fruitService.selectByPrimaryKey(id));
    }

    /**
     * 新增数据
     *
     * @param fruit 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public String add(@RequestBody  Fruit fruit) {
        return JSONArray.toJSONString(fruitService.insertSelective(fruit));
    }

    /**
     * 编辑数据
     *
     * @param fruit 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public String edit(@RequestBody Fruit fruit) {
        return JSONArray.toJSONString(fruitService.updateByPrimaryKeySelective(fruit));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public String deleteById(@RequestParam("id") Long id) {
        return JSONArray.toJSONString(fruitService.deleteByPrimaryKey(id));
    }

}

