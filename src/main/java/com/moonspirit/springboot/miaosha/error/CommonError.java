package com.moonspirit.springboot.miaosha.error;

public interface CommonError {
    int getErrorCode();
    String getErrorMsg();
    CommonError setErrorMsg(String errorMsg);
}
