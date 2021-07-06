package com.moonspirit.springboot.miaosha.controller;

import com.moonspirit.springboot.miaosha.controller.viewobject.UserVO;
import com.moonspirit.springboot.miaosha.error.BusinessException;
import com.moonspirit.springboot.miaosha.error.EnumBusinessError;
import com.moonspirit.springboot.miaosha.response.CommonReturnType;
import com.moonspirit.springboot.miaosha.service.UserService;
import com.moonspirit.springboot.miaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取对应ID的用户对象并返回
     *
     * @param id
     */
    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUserById(id);

        if(userModel == null) {
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }
}
