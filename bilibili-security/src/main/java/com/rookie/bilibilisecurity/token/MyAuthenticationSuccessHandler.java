package com.rookie.bilibilisecurity.token;

import com.rookie.bilibilibean.entity.TConsumers;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 认证成功
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    TConsumers tConsumers;

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        //生成token
        String token = Jwts.builder()
                .setSubject(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyKey")
                .compact();
        //将token返回
        System.out.println(token);
        response.setContentType("application/json;charset=UTF-8");
//        response.addHeader("Authorization", "Bearer " + token);
        PrintWriter out = response.getWriter();
        out.print(token);
        out.flush();
        out.close();
    }

}