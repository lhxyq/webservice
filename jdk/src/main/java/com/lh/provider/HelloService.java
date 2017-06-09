package com.lh.provider;

import javax.jws.WebService;

/**
 * Created by LH 2446059046@qq.com on 2017/6/10.
 */
@WebService
public interface HelloService {
    String say(String name);
}
