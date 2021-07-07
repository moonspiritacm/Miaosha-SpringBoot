package com.moonspirit.springboot.miaosha.controller;

import com.moonspirit.springboot.miaosha.error.BusinessException;
import com.moonspirit.springboot.miaosha.error.EnumBusinessError;
import com.moonspirit.springboot.miaosha.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception exception) {
        Map<String, Object> data = new HashMap<>();
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            data.put("errCode", businessException.getErrCode());
            data.put("errMsg", businessException.getErrMsg());
        } else {
            data.put("errCode", EnumBusinessError.UNKNOWN_ERROR.getErrCode());
            data.put("errMsg", EnumBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(data, "fail");
    }
}
