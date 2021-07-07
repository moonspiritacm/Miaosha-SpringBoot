package com.moonspirit.springboot.miaosha.util;

import com.moonspirit.springboot.miaosha.error.BusinessException;
import com.moonspirit.springboot.miaosha.error.EnumBusinessError;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;

public class SmsUtil {
    public static void sendSms(String telephone, String otpCode) throws BusinessException {
        Credential cred = new Credential("AKIDNYT8V6RVHn20i9KEvLVOzJNDo7BxSgeL", "RbU6RWBfvwiEVWHm34pKZYHkxvd6JGxP");

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("sms.tencentcloudapi.com");
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        SmsClient client = new SmsClient(cred, "ap-beijing", clientProfile);
        SendSmsRequest req = new SendSmsRequest();
        String[] phoneNumberSet1 = {telephone};
        String[] templateParamSet1 = {otpCode};
        req.setPhoneNumberSet(phoneNumberSet1);
        req.setTemplateParamSet(templateParamSet1);
        req.setSmsSdkAppId("1400544563");
        req.setSignName("伫倚危楼");
        req.setTemplateId("1026622");

        SendSmsResponse resp = null;
        try {
            resp = client.SendSms(req);
        } catch (TencentCloudSDKException e) {
            throw new BusinessException(EnumBusinessError.SMS_SEND_ERROR);
        }
        System.out.println(SendSmsResponse.toJsonString(resp));
    }
}
