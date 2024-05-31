package com.boy.controller;

import com.alibaba.fastjson2.JSONArray;
import com.boy.domain.User;
import com.boy.domain.bo.UserLoginBo;
import com.boy.domain.bo.UserRegBo;
import com.boy.domain.vo.ResponseVo;
import com.boy.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Oh...Yeah!!!
 * @since 2024-05-31 09:19:49
 */
@RestController
@RequestMapping(value = "user", produces = "text/plain;charset=UTF-8")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;



    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户注册
     * @param userRegBo
     * @return String.class
     */
    @PostMapping("/userReg")
    @ApiOperation("用户注册")
    public String userReg(@RequestBody UserRegBo userRegBo){
        if(userRegBo != null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x400"));
        }

        if(userRegBo.getPassword() != userRegBo.getRePassword()){
            JSONArray.toJSONString(new ResponseVo("两次密码输入的不一致",null,"0x400"));
        }


        return JSONArray.toJSONString(userService.userReg(userRegBo));
    }


    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户登录
     * @param userLoginBo
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public String userLogin(@RequestBody UserLoginBo userLoginBo){
        if(userLoginBo == null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.userLogin(userLoginBo));
    }



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.selectByPrimaryKey(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Integer> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Integer> edit(User user) {
        return ResponseEntity.ok(this.userService.updateByPrimaryKeySelective(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Integer> deleteById(Long id) {
        return ResponseEntity.ok(this.userService.deleteByPrimaryKey(id));
    }

}

