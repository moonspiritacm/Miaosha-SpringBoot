package com.moonspirit.springboot.miaosha.error;

public interface CommonError {
    int getErrCode();
    String getErrMsg();
    CommonError setErrMsg(String errorMsg);
}
