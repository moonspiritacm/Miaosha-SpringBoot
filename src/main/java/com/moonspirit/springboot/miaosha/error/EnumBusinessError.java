package com.moonspirit.springboot.miaosha.error;

public enum EnumBusinessError implements CommonError {
    // 100XX - 通用错误码
    UNKNOWN_ERROR(10000, "未知错误"),
    PAPAMETER_VALIDATION_ERROR(10001, "参数不合法"),

    // 200XX - 用户信息错误码
    USER_NOT_EXIST(20001, "用户不存在"),

    ;

    private int errCode;
    private String errMsg;

    private EnumBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    /**
     * 针对通用错误类型，自定义错误消息。常用于入参校验
     *
     * @param errorMsg
     * @return
     */
    @Override
    public CommonError setErrMsg(String errorMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
