package com.service;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//关于事务的传播行为的属性设置
@Transactional(timeout = -1, readOnly =false, propagation = Propagation.REQUIRED , isolation = Isolation.REPEATABLE_READ)
@Service
public class UserService {

    //注入dao
    @Autowired
    public UserDao userDao;



//    转账的方法
    public void accountMoney(){
 //       try{
//        第一步 开启事务

//        第二步，进行业务操作
            //lucy少100
            userDao.reduceMoney();

            int i = 10 / 0;

            //mary多100
            userDao.addMoney();

            //没有发生异常，提交事务
  //      }catch(Exception e){
            //发生异常，事务回滚
 //       }


    }
}
