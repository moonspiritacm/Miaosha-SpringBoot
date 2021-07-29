package com.moonspirit.springboot.miaosha.util;

import com.moonspirit.springboot.miaosha.error.BusinessException;
import com.moonspirit.springboot.miaosha.error.EnumBusinessError;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class MD5Util {
    public static String Encoder(String msg) throws BusinessException {
        String res = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            res = base64Encoder.encode(md5.digest(msg.getBytes("UTF-8")));
        } catch (Exception e) {
            throw new BusinessException(EnumBusinessError.SMS_ENCODE_ERROR);
        }
        return res;
    }
}
