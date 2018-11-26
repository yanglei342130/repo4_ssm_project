package cn.itcast.service.impl;

import cn.itcast.service.IAopTest;
import org.springframework.stereotype.Component;

@Component
public class AopTest implements IAopTest {

    @Override
    public  void aopTest() {
        System.out.println("我是aop测试");
    }

}
