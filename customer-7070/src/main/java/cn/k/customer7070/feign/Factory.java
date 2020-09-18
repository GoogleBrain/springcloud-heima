package cn.k.customer7070.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

@Service
public class Factory implements FallbackFactory<ProviderService> {

    @Override
    public ProviderService create(Throwable throwable) {
        return new ProviderService() {
            @Override
            public String getNowTIme() {
                System.out.println(throwable);
                return "你个棒槌，出错了。。。。。。";
            }
        };
    }
}
