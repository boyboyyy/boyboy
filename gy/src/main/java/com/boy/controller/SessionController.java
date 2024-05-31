package com.boy.controller;

import com.alibaba.fastjson2.JSONArray;
import com.boy.domain.Session;
import com.boy.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Session)表控制层
 *
 * @author Oh...Yeah!!!
 * @since 2024-05-31 09:19:34
 */
@RestController
@RequestMapping(value = "session", produces = "text/plain;charset=UTF-8")
public class SessionController {
    /**
     * 服务对象
     */
    @Resource
    private SessionService sessionService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public String queryById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(sessionService.selectByPrimaryKey(id));
    }

    /**
     * 新增数据
     *
     * @param session 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public String add(@RequestBody Session session) {
//
        return JSONArray.toJSONString(sessionService.insert(session));
    }

    /**
     * 编辑数据
     *
     * @param session 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public String edit(@RequestBody Session session) {
        return JSONArray.toJSONString(sessionService.updateByPrimaryKeySelective(session));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public String deleteById(@RequestParam("id")  Long id) {
        return JSONArray.toJSONString(sessionService.deleteByPrimaryKey(id));
    }

}

