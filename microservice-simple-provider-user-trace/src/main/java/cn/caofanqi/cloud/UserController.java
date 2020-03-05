package cn.caofanqi.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <p>Description:  </p>
 *
 * @author 曹凡启
 * @since 2020/3/2 0:54
 */
@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) throws InterruptedException {
        log.info("log....");
//        Thread.sleep(2000);
        return this.userRepository.findById(id);
    }

    @PostMapping
    public Long create(@RequestBody User user){
        user = userRepository.save(user);
        return user.getId();
    }
}
