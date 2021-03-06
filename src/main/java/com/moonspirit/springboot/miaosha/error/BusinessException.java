package com.moonspirit.springboot.miaosha.error;

/**
 * 包装器，业务异常类实现
 */
public class BusinessException extends Exception implements CommonError {
    private CommonError commonError;

    /**
     * 直接接收EnumBusinessError传参，构造业务异常
     *
     * @param commonError
     */
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    /**
     * 基于通用错误码，接收自定义错误消息，构造业务异常
     *
     * @param errMsg
     * @param commonError
     */
    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
