package com.dangdao.shop.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Authenterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,Object handler) throws Exception{
        if(req.getSession().getAttribute("account")==null){
            req.getSession().setAttribute("secureUri",req.getRequestURI());
            resp.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
