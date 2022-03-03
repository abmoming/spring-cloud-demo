package com.example.demogatewayuserserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoGatewayUserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGatewayUserServerApplication.class, args);
    }

    // 路由断言工厂
    /*@Bean
    public RouterFunction<ServerResponse> testFunRouterFunction() {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/testfun"),
                request -> ServerResponse.ok().body(BodyInserters.fromValue("hello"))
        );
        return route;
    }*/

    // 过滤器工厂
    // 网关经常需要对路由请求进行过滤，进行一些操作，如鉴权之后构造头部之类的，过滤的种类很多，如增加请求头、增加请求参数、增加响应头和断路器等等功能。
    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/image/webp213")
                        .filters(f ->
                                         f.addResponseHeader("X-AnotherHeader", "baz"))
                        .uri("http://httpbin.org:80")
                )
                .build();
    }*/

    // 如上实现了当请求路径为 /image/webp时，将请求转发到http://httpbin.org:80，并对响应进行过滤处理，增加响应的头部X-AnotherHeader：baz。


}