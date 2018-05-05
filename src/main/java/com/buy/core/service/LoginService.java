package com.buy.core.service;

import org.springframework.stereotype.Service;

//@Service 注解得加在实现类上，因为加了这个注解就相当于spring通过工厂去创建这个对象，而接口是不可以被实例化的
public interface LoginService {
    String Login(String username, String password);
}

