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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 获取对应ID的用户对象
     *
     * @param id 用户ID
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUserById(id);
        if (userModel == null) {
            // userModel.setId(1);
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }

    /**
     * 生成并发送OTP短信验证码
     *
     * @param telephone 用户手机号
     * @return
     */
    @RequestMapping(value = "/getotp", method = RequestMethod.POST, consumes = CONTENT_TYPE_FORMED)
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telephone") String telephone) throws BusinessException {
        // 生成OTP验证码
        Random random = new Random();
        int otpInt = random.nextInt(899999);
        otpInt += 100000;
        String otpCode = String.valueOf(otpInt);

        // 将OTP验证码同用户手机号相关联（HTTPSESSION）
        httpServletRequest.getSession().setAttribute(telephone, otpCode);

        // 将OTP验证码通过短信通道发送给用户
        System.out.println("telephone = " + telephone + " & otpCode = " + otpCode);
        // SmsUtil.sendSms(telephone, otpCode);
        return CommonReturnType.create(null);
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
