package com.lh.consumer;

import com.lh.provider.HelloService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by LH 2446059046@qq.com on 2017/6/10.
 */
public class Consumer {
    public static void main(String[] args) {
        try {
            URL wsdl = new URL("http://localhost:8080/ws/soap/hello?wsdl");

            QName serviceName = new QName("http://provider.lh.com/", "HelloService");
            QName portName = new QName("http://provider.lh.com/", "8080");

            Service service = Service.create(wsdl, serviceName);

            HelloService helloService = service.getPort(portName, HelloService.class);
            String result = helloService.say("刘辉...");

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
