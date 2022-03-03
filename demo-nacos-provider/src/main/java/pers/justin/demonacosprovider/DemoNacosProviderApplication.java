package pers.justin.demonacosprovider;

import java.util.concurrent.TimeUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableDiscoveryClient // 通过Spring Cloud原生注解 @EnableDiscoveryClient 开启服务注册发现功能
public class DemoNacosProviderApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoNacosProviderApplication.class, args);
        while(true){
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            String userName = environment.getProperty("user.name");
            String userAge = environment.getProperty("user.age");
            String currentEnv = environment.getProperty("env");
            System.err.println("in " + currentEnv + " enviroment;"+"user name :" + userName + "; age: " + userAge);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
