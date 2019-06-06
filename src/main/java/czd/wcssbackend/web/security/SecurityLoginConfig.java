package czd.wcssbackend.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityLoginConfig extends WebSecurityConfigurerAdapter {

    /**
     登陆框架配置信息
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login","/register","/doRegister")
                .permitAll()//注意这里hello.html需要配置成不需要身份认证，否则会报重定向次数过多
                .and()
                .formLogin()
                .loginPage("/login")//指定我们自己的登录页面
                .loginProcessingUrl("/testLogin")//指定让UsernamePasswordAuthenticationFilter拦截器拦截的路径
                .failureForwardUrl("/login?error=true")
                .defaultSuccessUrl("/index")//默认登录成功后跳转的页面
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

