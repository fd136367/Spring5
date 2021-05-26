package com.lenovo.webflux.handler;

import com.lenovo.webflux.entity.User;
import com.lenovo.webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {

    private final UserService userService;
    public UserHandler(UserService userService){
    this.userService = userService;
    }

    //根据id查询
    public Mono<ServerResponse> getById(ServerRequest request){
        //获取id值
        int id = Integer.valueOf(request.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        //调用server方法得到数据
        Mono<User> userMono = this.userService.getUserById(id);
        //把userMono进行转换返回
        //使用Reactor操作符flatMap
       return userMono.flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person))).switchIfEmpty(notFound);
    }
    //查询所有
    public Mono<ServerResponse> getAll(ServerRequest request){
        //调用service得到结果
        Flux<User> users = this.userService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users,User.class);
    }

    //添加
    public Mono<ServerResponse> saveUser(ServerRequest request){
        //得到User对象
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUser(userMono));
    }
}
