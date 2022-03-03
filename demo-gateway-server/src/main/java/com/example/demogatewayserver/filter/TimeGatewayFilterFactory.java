package com.example.demogatewayserver.filter;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

/**
 * 类说明 
 *
 * @organization: Rayo Technology  
 * @author Justin
 * @email 1099397095@qq.com 
 * @date 2022/3/3 15:19
 */
@Component // 名称是有固定格式xxxGatewayFilterFactory
public class TimeGatewayFilterFactory extends AbstractGatewayFilterFactory<TimeGatewayFilterFactory.Config> {

    private static final String BEGIN_TIME = "beginTime";

    // 构造函数
    public TimeGatewayFilterFactory() {
        super(TimeGatewayFilterFactory.Config.class);
    }

    // 读取配置文件中的参数，赋值到配置类中
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("show");
    }

    @Override
    public GatewayFilter apply(TimeGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {
            if(!config.show){
                // 如果配置类中的show为false，表示放行
                return chain.filter(exchange);
            }
            exchange.getAttributes().put(BEGIN_TIME, System.currentTimeMillis());
            /**
             * pre的逻辑
             * chain.filter().then(Mono.fromRunable(() -> {
             *     post的逻辑
             * }))
             */
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                Long startTime = exchange.getAttribute(BEGIN_TIME);
                if (!ObjectUtils.isEmpty(startTime)) {
                    System.err.println(exchange.getRequest().getURI() + "请求耗时：" + (System.currentTimeMillis() - startTime) + "ms");
                }
            }));
        };
    }

    @Setter
    @Getter
    static class Config {
        private boolean show;
    }
}
