package com.lh.provider;

import javax.xml.ws.Endpoint;

/**
 * Created by LH 2446059046@qq.com on 2017/6/10.
 */
public class Provider {
    public static void main(String[] args) {
        final String address = "http://localhost:8080/ws/soap/hello";
        final HelloService helloService = new HelloServiceImpl();

        Endpoint.publish(address, helloService);

        System.out.println("ws has published......");
    }
}
