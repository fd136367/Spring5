package com.lenovo.reacter.JavaReactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestReactor {

    public static void main(String[] args) {
        //just方法直接声明
        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);

//        //数组的方法
//        Integer[] array = { 1 , 2 , 3 , 4};
//        Flux.fromArray(array);
//
//        //集合的操作
//        List<Integer> list = Arrays.asList(array);
//        Flux.fromIterable(list);
//
//        //流的操作
//        Stream<Integer> stream = list.stream();
//        Flux.fromStream(stream);
    }
}
