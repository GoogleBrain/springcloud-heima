package cn.k.customer7070.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider-8080",
        //fallback = ProviderServiceImple.class
        fallbackFactory = Factory.class
)
public interface ProviderService {

    @RequestMapping("/nowtime")
    public String getNowTIme();
}
