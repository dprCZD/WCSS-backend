package czd.wcssbackend.web.security;


import czd.wcssbackend.web.security.UserHandler.UserAuthenticationFailHandler;
import czd.wcssbackend.web.security.UserHandler.UserAuthenticationSuccessHandler;
import czd.wcssbackend.web.security.UserHandler.UserLogoutSuccessHandler;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityLoginConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private UserAuthenticationFailHandler authenticationFailHandler;
    @Autowired
    private UserLogoutSuccessHandler logoutSuccessHandler;


    /**
     登陆框架配置信息
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/controller"
                        ,"/api/v1/login/form"
                        ,"/api/v1/login"
                        ,"/api/v1/register",
                        "/api/v1/doRegister",
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/swagger-resources/configuration/ui")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/api/v1/login")//指定我们自己的登录页面
                .loginProcessingUrl("/api/v1/login/form")//指定让UsernamePasswordAuthenticationFilter拦截器拦截的路径
                .and()
                .logout().logoutUrl("/api/v1/logout").logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.addFilterAt(customAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailHandler);
        filter.setFilterProcessesUrl("/api/v1/login/form");
        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public  UserAuthenticationSuccessHandler getAuthenticationSuccessHandler()
    {
        return new UserAuthenticationSuccessHandler();
    }
    @Bean
    public  UserAuthenticationFailHandler getAuthenticationFailHandler()
    {
        return new UserAuthenticationFailHandler();
    }
    @Bean
    public  UserLogoutSuccessHandler getUserLogoutSuccessHandler()
    {
        return new UserLogoutSuccessHandler();
    }
    @Bean
    public ObjectMapper getObjectMapper()
    {
        return new ObjectMapper();
    }
}

