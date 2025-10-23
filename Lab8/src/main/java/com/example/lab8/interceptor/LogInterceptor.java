package com.example.lab8.interceptor;

import com.example.lab8.entity.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Account user = (Account) request.getSession().getAttribute("user");
        if (user != null) {
            System.out.println(request.getRequestURI() + ", " + new Date() + ", " + user.getFullname());
        }
        return true;
    }
}
