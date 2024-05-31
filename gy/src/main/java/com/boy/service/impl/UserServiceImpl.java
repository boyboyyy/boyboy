package com.boy.service.impl;

import com.boy.domain.bo.UserLoginBo;
import com.boy.domain.bo.UserRegBo;
import com.boy.domain.vo.ResponseVo;
import com.boy.utils.JwtUtil;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.boy.mapper.UserMapper;
import com.boy.domain.User;
import com.boy.service.UserService;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * @param userLoginBo
     * @return ResponseVo.class
     * @Auther Oh… Yeah!!! 2024-3-5
     * 用户注册
     */
    public ResponseVo userReg(UserRegBo userRegBo){

        System.out.println(userRegBo);
        User user = userMapper.findByUsername(userRegBo.getUsername());

        if(user != null){
            return new ResponseVo("该用户名已存在",null,"0x202");
        }

        Long aLong = userMapper.userReg(new User(
                userRegBo.getUsername(),
                userRegBo.getPassword(),
                0,
                new Date(),
                new Date(),
                0
        ));

        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x203");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户登录
     * @param userLoginBo
     * @return ResponseVo.class
     */
    public ResponseVo userLogin(UserLoginBo userLoginBo){
        //通过username去获取用户
        User user = userMapper.findByUsername(userLoginBo.getUsername());

        //比较用户密码和数据库中密码是否一致
        if(user == null || !user.getPassword().equals(userLoginBo.getPassword())){
            return new ResponseVo("登录失败",null,"0x500");
        }

        String jwt = JwtUtil.createJWT(user);


        //修改当前的登录时间
        user.setUpdateTime(new Date());
        userMapper.updateLoginTime(user);

        return new ResponseVo("登录成功",jwt,"0x200");
    }



    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
