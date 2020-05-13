package com.immoc.miaosha.service;

import com.immoc.miaosha.dao.UserDao;
import com.immoc.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public User getById(int id){
        return userDao.getById(id);
    }

    @Transactional//保证事务的进行 如果 不加注解的话  数据库中则会加入这条id为2的属性
    public boolean tx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("yxq2");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("yxq1");
        userDao.insert(u2);
        return true;
    }
}
