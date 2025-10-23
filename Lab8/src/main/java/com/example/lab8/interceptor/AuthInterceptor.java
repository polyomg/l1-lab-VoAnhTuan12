package com.example.lab8.interceptor;

import com.example.lab8.entity.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        HttpSession session = request.getSession();
        session.setAttribute("securityUri", uri);
        Account user = (Account) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/auth/login");
            return false;
        }
        if (uri.startsWith("/admin") && !user.isAdmin()) {
            response.sendRedirect("/auth/login");
            return false;
        }
        return true;
    }
}
