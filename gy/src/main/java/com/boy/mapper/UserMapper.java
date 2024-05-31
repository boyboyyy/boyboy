package com.boy.mapper;

import com.boy.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  更新登录时间
     * @param user
     * @return
     */
    public void updateLoginTime(User user);


    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  查找用户名
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  注册用户
     * @param user
     * @return
     */
    public Long userReg(User user);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
