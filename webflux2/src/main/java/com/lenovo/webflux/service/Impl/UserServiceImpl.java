package com.lenovo.webflux.service.Impl;

import com.lenovo.webflux.entity.User;
import com.lenovo.webflux.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserServiceImpl implements UserService {

    //创建map集合存储数据
    private final Map<Integer,User>  user = new HashMap<>();

    public UserServiceImpl(){
    this.user.put(1,new User("jack","nan",20));
    this.user.put(2,new User("lucy","nv",22));
    this.user.put(3,new User( "mary","nv",30));
    }

    @Override
    public Mono<User> getUserById(Integer id) {
        return Mono.just(this.user.get(id));
    }

    @Override
    public Flux<User> getAll() {
        return Flux.fromIterable(this.user.values());
    }

    //添加操作
    @Override
    public Mono<Void> saveUser(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            int id = user.size()+1;
            user.put(id,person);
        }).thenEmpty(Mono.empty());
    }
}
