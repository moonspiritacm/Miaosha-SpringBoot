package com.moonspirit.springboot.miaosha;

import com.moonspirit.springboot.miaosha.dao.UserInfoDOMapper;
import com.moonspirit.springboot.miaosha.dataobject.UserInfoDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = {"com.moonspirit.springboot.miaosha"})
@MapperScan("com.moonspirit.springboot.miaosha.dao")
@RestController
public class Application {

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/username")
    public String getUserName() {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(1);
        if (userInfoDO == null) {
            return "用户对象不存在！";
        }
        return userInfoDO.getName();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(Application.class, args);
    }
}
