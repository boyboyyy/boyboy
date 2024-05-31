package com.boy.service;

import com.boy.domain.User;
import com.boy.domain.bo.UserLoginBo;
import com.boy.domain.vo.ResponseVo;

public interface UserService{

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户登录
     * @param userLoginBo
     * @return ResponseVo.class
     */
    ResponseVo userLogin(UserLoginBo userLoginBo);

    /**
     * @param userLoginBo
     * @return ResponseVo.class
     * @Auther Oh… Yeah!!! 2024-3-5
     * 用户注册
     */
    ResponseVo userReg(UserLoginBo userLoginBo);




    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
