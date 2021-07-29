package com.moonspirit.springboot.miaosha.error;

public enum EnumBusinessError implements CommonError {
    // 100XX - 通用错误码
    UNKNOWN_ERROR(10000, "未知错误"),
    PAPAMETER_VALIDATION_ERROR(10001, "参数不合法"),

    // 200XX - 系统错误码
    SMS_SEND_ERROR(20001, "短信验证码发送失败"),
    SMS_ENCODE_ERROR(20002, "明文加密失败"),

    // 300XX - 用户信息错误码
    USER_NOT_EXIST(30001, "用户不存在"),
    USER_LOGIN_FAIL(30002, "用户手机号或密码不正确"),

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
     * @param errMsg
     * @return
     */
    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
