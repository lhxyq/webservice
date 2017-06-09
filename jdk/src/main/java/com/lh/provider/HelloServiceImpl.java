package com.lh.provider;

import javax.jws.WebService;

/**
 * Created by LH 2446059046@qq.com on 2017/6/10.
 */
@WebService(serviceName = "HelloService", portName = "8080", endpointInterface="com.lh.provider.HelloService")
public class HelloServiceImpl implements HelloService {
    public String say(String name) {
        return "hello " + name;
    }
}
