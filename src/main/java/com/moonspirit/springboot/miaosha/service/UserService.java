package com.moonspirit.springboot.miaosha.service;

import com.moonspirit.springboot.miaosha.error.BusinessException;
import com.moonspirit.springboot.miaosha.service.model.UserModel;

public interface UserService {
    /**
     * 通过用户ID获取用户对象
     *
     * @param id
     * @return
     */
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;
}
