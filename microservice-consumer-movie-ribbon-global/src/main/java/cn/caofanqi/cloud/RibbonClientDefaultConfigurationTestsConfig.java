package cn.caofanqi.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon只支持使用代码实现全局配置
 */
@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class RibbonClientDefaultConfigurationTestsConfig {
}

@Configuration
class DefaultRibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}