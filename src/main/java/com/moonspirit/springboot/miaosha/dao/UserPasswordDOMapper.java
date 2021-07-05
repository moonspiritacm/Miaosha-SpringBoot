package com.moonspirit.springboot.miaosha.dao;

import com.moonspirit.springboot.miaosha.dataobject.UserPasswordDO;

public interface UserPasswordDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserPasswordDO record);

    int insertSelective(UserPasswordDO record);

    UserPasswordDO selectByPrimaryKey(Integer id);

    UserPasswordDO selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserPasswordDO record);

    int updateByPrimaryKey(UserPasswordDO record);
}
