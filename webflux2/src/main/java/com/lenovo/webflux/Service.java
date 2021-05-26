package com.lenovo.webflux;

import com.lenovo.webflux.handler.UserHandler;
import com.lenovo.webflux.service.Impl.UserServiceImpl;
import com.lenovo.webflux.service.UserService;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;


public class Service {

    public static void main(String[] args) throws Exception{
        Service service = new Service();
        service.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //创建Router路由
    public RouterFunction<ServerResponse> routerFunction(){
        //创建handler
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        //设置路由
        return RouterFunctions.route(GET("/user/{id}").and(accept(APPLICATION_JSON)),handler::getById).andRoute(GET("users").and(accept(APPLICATION_JSON)),handler::getAll);
    }
    //创建服务器完成适配
    private void createReactorServer(){
        //路由器和handler适配
        RouterFunction<ServerResponse> function = routerFunction();
        HttpHandler handler = toHttpHandler(function);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);

        //创建服务器
        HttpServer server = HttpServer.create();
        server.handle(adapter).bindNow();
    }
}
