package com.example.demogatewayuserserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明 
 *
 * @organization: Rayo Technology  
 * @author Justin
 * @email 1099397095@qq.com 
 * @date 2022/3/3 14:56
 */
@RestController
public class GatewayUserServerController {

    /* 只需要按照：网关地址/微服务名称/接口的格式去访问，就可以得到成功响应 */
    @PostMapping("/product")
    public String getProduct() {
        return "product";
    }

    @GetMapping("/order")
    public String getOrder() {
        return "order";
    }
}