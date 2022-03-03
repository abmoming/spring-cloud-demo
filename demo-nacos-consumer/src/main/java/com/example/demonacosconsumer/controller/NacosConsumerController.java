package com.example.demonacosconsumer.controller;

import com.example.demonacosconsumer.feign.NacosProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明 
 *
 * @organization: Rayo Technology  
 * @author Justin
 * @email 1099397095@qq.com  
 * @date 2022/3/2 14:44
 */
@RestController
public class NacosConsumerController {

    @Autowired
    private NacosProviderFeign nacosProviderFeign;

    @GetMapping("/hi")
    public String hi() {
        return nacosProviderFeign.hello();
    }
}
