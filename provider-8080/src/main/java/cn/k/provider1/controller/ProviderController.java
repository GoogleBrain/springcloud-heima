package cn.k.provider1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/nowtime")
    public String nowTime(){

        return "当前时间>>>>>"+new Date()+",端口号："+port;
    }
}
