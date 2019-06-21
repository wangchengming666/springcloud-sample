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
        return "sorry" + name;
    }
}
