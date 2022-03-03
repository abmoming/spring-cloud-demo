package pers.justin.demonacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明 
 *
 * @organization: Rayo Technology  
 * @author Justin
 * @email 1099397095@qq.com  
 * @date 2022/3/2 14:19
 */
@RestController
public class NacosProviderController {

    @Value("${myName}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return "hello, " + name;
    }
}
