package com.buy.core.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author: zhengkai
 * @create: 2018-05-05
 * @desc:
 **/
@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean(name = "responseFilter" ,autowire = Autowire.BY_TYPE)
    public ResponseFilter responseFilter() {
        return new ResponseFilter();
    }

    @Autowired
    private ResponseFilter responseFilter;

    //注册静态资源，没注册的话，网站是访问不了的
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }

    //添加拦截器,解决返回值的乱码问题
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseFilter).addPathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/demo/login").setViewName("login");
        registry.addViewController("/demo/users").setViewName("users");
    }
}
