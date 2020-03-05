package cn.caofanqi.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * <p>Description: 用户feign调用 </p>
 *
 * @author 曹凡启
 * @since 2020/3/3 20:04
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {


    @GetMapping("users/{id}")
    User findById(@PathVariable("id") Long id);

}
