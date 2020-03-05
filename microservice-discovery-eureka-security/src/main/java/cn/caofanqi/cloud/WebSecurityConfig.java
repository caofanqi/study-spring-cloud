package cn.caofanqi.cloud;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p>Description: security配置类 </p>
 *
 * @author 曹凡启
 * @since 2020/3/3 5:10
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Spring Cloud Finchley及更高版本，必须添加如下代码，部分关闭掉Spring Security的CSRF保护功能，否则应用无法正常注册！
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
