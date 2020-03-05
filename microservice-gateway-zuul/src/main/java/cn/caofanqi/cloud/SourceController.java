package cn.caofanqi.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: zuul的跳转路由 </p>
 *
 * @author 曹凡启
 * @since 2020/3/4 19:45
 */
@RestController
public class SourceController {


    @GetMapping("source/hello/{name}")
    public String hello(@PathVariable("name")String name){
        return "hello : " + name;
    }

}
