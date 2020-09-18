package cn.k.gateway.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RefreshScope
@RestController
public class Hell {

    @Value("${nacos.count}")
    private int count;

    @RequestMapping("/abc")
    public String k() {
        return count + "";
    }
}
