package com.example.demonacosconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类说明 
 *
 * @organization: Rayo Technology  
 * @author Justin
 * @email 1099397095@qq.com  
 * @date 2022/3/2 14:58
 */
@FeignClient("nacos-provider")
public interface NacosProviderFeign {

    @GetMapping("hello")
    String hello();
}
