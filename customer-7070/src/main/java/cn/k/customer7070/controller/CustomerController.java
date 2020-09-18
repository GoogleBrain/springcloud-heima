package cn.k.customer7070.controller;

import cn.k.customer7070.feign.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private ProviderService providerService;


    @RequestMapping("/getnowtime4")
    public String getNowTime4(){
        return "feign>>>>>"+providerService.getNowTIme();
    }


    @RequestMapping("/getnowtime")
    public String getNowTime(){
          return restTemplate.getForEntity("http://localhost:8080/nowtime",String.class).getBody();
    }

    @RequestMapping("/getnowtime2")
    public String getNowTime2(){
        List<ServiceInstance> instances = discoveryClient.getInstances("provider-8080");
        ServiceInstance serviceInstance = instances.get(0);

        return "discoveryClient>>>>>"+restTemplate.getForEntity("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/nowtime",String.class).getBody();
    }

    @RequestMapping("/getnowtime3")
    public String getNowTime3(){
        List<ServiceInstance> instances = discoveryClient.getInstances("provider-8080");
        ServiceInstance serviceInstance = instances.get(0);

        return "discoveryClient>>>>>"+restTemplate.getForEntity("http://provider-8080/nowtime",String.class).getBody();
    }





}
