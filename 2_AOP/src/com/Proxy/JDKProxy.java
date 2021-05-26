package com.Proxy;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args) {

        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = dao.add(1, 2);
        System.out.println("add="+add);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler{
        //把创建的是谁的代理对象，把谁传递过来
        //有参数构造传递
        private Object obj;
        public UserDaoProxy(Object obj){
            this.obj = obj;
        }
        //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法执行之前...."+method.getName()+"传递的参数..."+ Arrays.toString(args));
        //被增强的方法执行
        Object invoke = method.invoke(obj, args);
        //方法之后
        System.out.println("方法执行之后..."+obj);
        return invoke;
    }
}