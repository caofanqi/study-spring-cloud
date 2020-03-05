package cn.caofanqi.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * <p>Description: 用户feign调用 </p>
 *
 * @author 曹凡启
 * @since 2020/3/3 20:04
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @GetMapping("users/{id}")
    User findById(@PathVariable("id") Long id);

    @PostMapping("users")
    Long createUser(@RequestBody User user);

}
