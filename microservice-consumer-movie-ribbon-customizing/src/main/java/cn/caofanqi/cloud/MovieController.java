package cn.caofanqi.cloud;

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
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
//        User user = this.restTemplate.getForObject("http://localhost:8000/users/{id}", User.class, id);
        /**
         * 使用eureka和Ribbon后，可以通过在eureka上的目标服务名称进行调用，
         * 也就是http://{目标服务名称}/{目标服务端点} 的形式，Ribbon会自动在实际调用时，将目标服务名替换为该服务的IP和端口。
         * 注意：
         * 这里的目标服务名称，在Ribbon里叫虚拟主机名 ，主机名是不能包含_ 等特殊字符的。这意味着，
         * 一般不建议配置spring.application.name = xxx_xxx ，如果你的应用名称一定带有下划线这种字符，
         * 那么请额外配置eureka.instance.virtual-host-name = 一个合法的主机名 ，
         * 否则Ribbon将会提示虚拟主机名不合法的异常！
         */
        User user = this.restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
        // ...电影微服务的业务...
        return user;
    }


}
