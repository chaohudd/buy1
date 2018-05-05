package com.buy.core.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.buy.core.mapper.UserInfoMapper;
import com.buy.core.model.UserInfo;
import com.buy.core.model.UserInfoExample;
import com.buy.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public String Login(String username, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        UserInfoExample userInfoExample = new UserInfoExample();
        dtoExample(userInfoExample, userInfo);
        List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
        if (list.size() == 0) {
            throw new RuntimeException("用户名错误！");
        }
        if (!list.get(0).getPassword().equals(password)) {
            throw new RuntimeException("密码错误！");
        }
//        return "登录成功";
//        直接返回乱码，加了拦截器也乱码，搞不定了，抛个异常先
        throw new RuntimeException("登录成功");
    }


      //将条件封装到mapper可用的类中
//    private UserInfoExample dtoExample(UserInfo userInfo, String orderby, Page page) {
//        UserInfoExample example = new UserInfoExample();
//        this.dtoExample(example, userInfo);
//        if (StringUtil.isNotBlank(orderby)) {
//            example.setOrderByClause(orderby);
//        }
//        if (page != null) {
//            example.setPage(page);
//        } else {
//            example.setPage(new Page());
//        }
//        return example;
//    }
//    private UserInfoExample dtoExample(UserInfo userInfo) {
//        return dtoExample(userInfo, null, null);
//    }
//    private UserInfoExample dtoExample(UserInfo userInfo, Page page) {
//        return dtoExample(userInfo, null, page);
//    }
//    private UserInfoExample dtoExample(UserInfo userInfo, String orderby) {
//        return dtoExample(userInfo, orderby, null);
//    }
    private void dtoExample(UserInfoExample example, UserInfo userInfo) {
        if (userInfo == null) {
            userInfo = new UserInfo();
        }
        UserInfoExample.Criteria criteria = example.createCriteria();
        if (userInfo.getId() != null) {
            criteria.andIdEqualTo(userInfo.getId());
        }
        if (!" ".equals(userInfo.getLoginName()) && userInfo.getLoginName() != null) {
            criteria.andLoginNameEqualTo(userInfo.getLoginName());
        }
        if (!" ".equals(userInfo.getUsername()) && userInfo.getUsername() != null) {
            criteria.andUsernameEqualTo(userInfo.getUsername());
        }
        if (!" ".equals(userInfo.getPassword()) && userInfo.getPassword() != null) {
            criteria.andPasswordEqualTo(userInfo.getPassword());
        }
        if (userInfo.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(userInfo.getCreateTime());
        }
        if (userInfo.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(userInfo.getUpdateTime());
        }
        if (!" ".equals(userInfo.getInfoStatus()) && userInfo.getInfoStatus() != null) {
            criteria.andInfoStatusEqualTo(userInfo.getInfoStatus());
        }
        if (userInfo.getSex() != null) {
            criteria.andSexEqualTo(userInfo.getSex());
        }
    }

}
