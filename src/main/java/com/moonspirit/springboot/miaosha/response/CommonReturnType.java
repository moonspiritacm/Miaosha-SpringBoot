package com.moonspirit.springboot.miaosha.response;

public class CommonReturnType {

    /**
     * 返回处理结果：success/fail
     */
    private String status;

    /**
     * 若status=success，则data内返回对应JSON数据；
     * 若status=fail，则data内使用通用的错误码格式。
     */
    private Object data;

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
