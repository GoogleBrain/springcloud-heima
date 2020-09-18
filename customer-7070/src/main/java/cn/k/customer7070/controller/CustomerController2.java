package cn.k.customer7070.controller;

import cn.k.customer7070.feign.ProviderService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class CustomerController2 {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getnowtime5")
    public String getNowTime5(){
        int a=10/0;
        return "5>>>>>"+new Date()+"端口号："+port+"***************";
    }

    @RequestMapping("/getnowtime6")
    public String getNowTime6(){
        return "6>>>>>"+new Date()+"端口号："+port;
    }

    /**
     * 热点的必须加SentinelResource
     * @param id
     * @param name
     * @return
     */
    @SentinelResource(value = "getnowtime7")
    @RequestMapping("/getnowtime7")
    public String getNowTime7(Integer id,String name){
        return "7>>>>"+id+"-----"+name+"端口号："+port;
    }
}
