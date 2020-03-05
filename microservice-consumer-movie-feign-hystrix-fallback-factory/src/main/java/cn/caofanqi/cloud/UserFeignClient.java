package cn.caofanqi.cloud;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * <p>Description: 用户feign调用 </p>
 *
 * @author 曹凡启
 * @since 2020/3/3 20:04
 */
@FeignClient(value = "microservice-provider-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {


    @GetMapping("users/{id}")
    User findById(@PathVariable("id") Long id);

}

@Slf4j
@Component
class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {


    /**
     * 错误日志最好放到各个fallback方法中，不要直接方法create方法中
     */
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                log.error("进入回退逻辑", throwable);
                return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
            }
        };
    }
}


