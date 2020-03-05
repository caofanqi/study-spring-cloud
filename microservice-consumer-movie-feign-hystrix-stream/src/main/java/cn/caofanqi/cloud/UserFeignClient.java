package cn.caofanqi.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>Description: 用户feign调用 </p>
 *
 * @author 曹凡启
 * @since 2020/3/3 20:04
 */
@FeignClient(value = "microservice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {


    @GetMapping("users/{id}")
    User findById(@PathVariable("id") Long id);

}

@Component
class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}


