package com.wzhy.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzhy.pojo.RespBean;
import com.wzhy.pojo.User;
import com.wzhy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/rigesterTeacher").permitAll()
                .antMatchers("/rigesterStudent").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("id")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
//                写了就没有自带的了
                .loginPage("/login")
//                登录成功的回调
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
//                        hr是登陆成功的用户
                        User hr = (User)authentication.getPrincipal();
//                        前端不显示密码
                        hr.setPassword(null);
                        RespBean ok = RespBean.ok("登陆成功", hr);
//                        返回json对象
                        String s = new ObjectMapper().writeValueAsString(ok);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
//                登陆时失败的回调
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();

                        RespBean respBean = RespBean.error("登陆失败!");
//                        如果账户是被锁定
                        if(exception instanceof LockedException)
//                        hr是登陆成功的用户
                        {
                            respBean.setMsg("账户被锁定 请联系管理员");
                        }
//                        密码过期
                        else  if(exception instanceof CredentialsExpiredException){
                            respBean.setMsg("密码过期 请联系管理员");
                        }else if(exception instanceof AccountExpiredException){
                            respBean.setMsg("账户过期请联系管理员");
                        }else if(exception instanceof DisabledException){
                            respBean.setMsg("账户被禁用 请联系管理员");
                        }else if (exception instanceof BadCredentialsException){
                            respBean.setMsg("用户名或密码输入错误 请重新输入");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
//                注销
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();

    }
}
