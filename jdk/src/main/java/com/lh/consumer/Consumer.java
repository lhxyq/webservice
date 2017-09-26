package com.lh.consumer;

import com.lh.provider.HelloService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LH 2446059046@qq.com on 2017/6/10.
 */
public class Consumer {
    public static void main(String[] args) throws Exception{
        /*try {
            URL wsdl = new URL("http://localhost:8080/ws/hello?wsdl");

            QName serviceName = new QName("http://provider.lh.com/", "HelloService");
            QName portName = new QName("http://provider.lh.com/", "helloServicePort");

            Service service = Service.create(wsdl, serviceName);

            HelloService helloService = service.getPort(portName, HelloService.class);
            String result = helloService.say("刘辉...");
            int add = helloService.add(1 , 5);

            System.out.println(result + "\t" + add);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //服务的地址
        URL wsUrl = new URL("http://localhost:8080/ws/hello");

        HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();

        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

        OutputStream os = conn.getOutputStream();

        //请求体
        String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:prov=\"http://provider.lh.com/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <prov:add>\n" +
                "         <arg0>1</arg0>\n" +
                "         <arg1>8</arg1>\n" +
                "      </prov:add>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        os.write(soap.getBytes());

        InputStream is = conn.getInputStream();

        byte[] b = new byte[1024];
        int len = 0;
        String s = "";
        while((len = is.read(b)) != -1){
            String ss = new String(b,0,len,"UTF-8");
            s += ss;
        }
        System.out.println(s);

        is.close();
        os.close();
        conn.disconnect();
    }
}
