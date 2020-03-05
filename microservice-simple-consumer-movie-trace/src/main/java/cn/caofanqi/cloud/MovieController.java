package cn.caofanqi.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: 电影controller </p>
 *
 * @author 曹凡启
 * @since 2020/3/3 3:02
 */
@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        log.info("调用user服务...");
        User user = this.restTemplate.getForObject("http://localhost:8000/users/{id}", User.class, id);
        // ...电影微服务的业务...
        return user;
    }


}
