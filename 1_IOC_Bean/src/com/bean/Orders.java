package com.bean;

public class Orders {

    //无参数构造
    public Orders() {
        System.out.println("第一步 执行无参数构造，创建bean实例");
    }

    private String oname;

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步：调用set方法设置值");
    }

    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("第三步 执行初始化的方法");
    }

    //创建执行的销毁方法
    public void desroyMethod() {
        System.out.println("第五步 执行销毁的方法");
    }

}
