package cn.caofanqi.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * <p>Description: 电影controller </p>
 *
 * @author 曹凡启
 * @since 2020/3/3 3:02
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }


}
