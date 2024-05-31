package com.boy.controller;

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
@RequestMapping("session")
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
    public ResponseEntity<Session> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.sessionService.selectByPrimaryKey(id));
    }

    /**
     * 新增数据
     *
     * @param session 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Integer> add(Session session) {
        return ResponseEntity.ok(this.sessionService.insert(session));
    }

    /**
     * 编辑数据
     *
     * @param session 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Integer> edit(Session session) {
        return ResponseEntity.ok(this.sessionService.updateByPrimaryKeySelective(session));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Integer> deleteById(Long id) {
        return ResponseEntity.ok(this.sessionService.deleteByPrimaryKey(id));
    }

}

