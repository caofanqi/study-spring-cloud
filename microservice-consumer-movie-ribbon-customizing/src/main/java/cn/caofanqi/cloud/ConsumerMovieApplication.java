package cn.caofanqi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplication.class, args);
    }

    /**
     * 只需在RestTemplate 上添加LoadBalanced 注解，即可让RestTemplate整合Ribbon
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
