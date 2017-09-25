package com.lh.provider;

import javax.jws.WebService;

/**
 * Created by LH 2446059046@qq.com on 2017/6/10.
 */
@WebService(serviceName = "HelloService", portName = "helloServicePort", endpointInterface="com.lh.provider.HelloService")
public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
