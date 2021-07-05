package com.moonspirit.springboot.miaosha.service.impl;

import com.moonspirit.springboot.miaosha.dao.UserInfoDOMapper;
import com.moonspirit.springboot.miaosha.dao.UserPasswordDOMapper;
import com.moonspirit.springboot.miaosha.dataobject.UserInfoDO;
import com.moonspirit.springboot.miaosha.dataobject.UserPasswordDO;
import com.moonspirit.springboot.miaosha.service.UserService;
import com.moonspirit.springboot.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(id);
        if (userInfoDO == null) {
            return null;
        }

        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userInfoDO.getId());
        return convertFromDataObject(userInfoDO, userPasswordDO);
    }

    private UserModel convertFromDataObject(UserInfoDO userInfoDO, UserPasswordDO userPasswordDO) {
        if (userInfoDO == null) {
            return null;
        }

        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userInfoDO, userModel);
        if (userPasswordDO != null) {
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
