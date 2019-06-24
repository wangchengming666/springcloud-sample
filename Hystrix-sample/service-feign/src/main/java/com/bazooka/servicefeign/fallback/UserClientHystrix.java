package com.bazooka.servicefeign.fallback;

import com.bazooka.servicefeign.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * Created by Beck Wang on 2019-06-21
 */
@Component
public class UserClientHystrix implements UserClient {

    @Override
    public String sayHello(String name) {
        return "sorry " + name + " 上游服务断开, 服务降级";
    }

    @Override
    public String timeOut() throws InterruptedException {
        return "链接超时，服务降级";
    }

    @Override
    public String exception() throws Exception {
        return "发生异常，服务降级";
    }
}
