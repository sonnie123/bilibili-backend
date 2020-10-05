package com.rookie.bilibilisecurity.config;

import com.rookie.bilibilisecurity.token.JWTAuthenticationFilter;
import com.rookie.bilibilisecurity.token.MyAuthenticationFailureHandler;
import com.rookie.bilibilisecurity.token.MyAuthenticationSuccessHandler;
import com.rookie.bilibilisecurity.token.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

// Security 配置,继承WebSecurityConfigurerAdapter这个类
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationFailureHandler failureHandler;

    @Autowired
    private MyAuthenticationSuccessHandler successHandler;

    @Autowired
    private UserDetailsServiceImpl userDetails;

    @Autowired
    JWTAuthenticationFilter jwtAuthenticationFilter;
    // 认证用户信息和权限
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(new BCryptPasswordEncoder());
    }

    // 配置拦截请求资源
    protected void configure(HttpSecurity http) throws Exception {
        //1。解决跨域问题，ors预检请求放行，让spring security放行所有preflight request(cors 预检请求)
        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        //2.让security永远不会创建httpSession,它不会使用httpSession来获取securityContext
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().headers().cacheControl();

        //3.请求权限控制
        //放行注册API请求，其它任何请求都必须经过身份验证
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/register").permitAll();

        http.formLogin()  //表单登录默认登录页面是/login 默认登录处理路径（form action）也是也是/login
                .loginPage("/login")//配置自定义登录页面
                .successHandler(successHandler) //定义登录成功处理
                .failureHandler(failureHandler).and() //定义登录失败处理
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 不需要session验证，加上token不好使。
                .authorizeRequests()
                .antMatchers("/login.html","/login").permitAll()//不校验我们配置的登录页面
                .anyRequest().authenticated().and() //其他页面都校验
                .csrf()
                .disable() //不允许csr
                .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class); //验证token操作
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }
}
