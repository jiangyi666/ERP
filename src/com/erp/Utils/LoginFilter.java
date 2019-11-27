package com.erp.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        //获取HttpSession对象，判断是否登陆

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path=request.getContextPath();// "/erp"
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();//http://localhost:8080
        String url = request.getRequestURI().toString();// "/erp/请求的"
        String currUrl = basePath + url;// "http://locatlhost:8080/erp/请求的"
        //在不为登陆页面时，再进行判断，如果不是登陆页面也没有session则跳转到登录页面，
        System.out.println("跳转" + currUrl);
        System.out.println(basePath + "/erp/login.jsp");
        if (request.getSession().getAttribute("employee") != null || currUrl.equals(basePath + path+"/login.jsp") ||
                currUrl.equals(basePath + path+"/loginServlet.do")) {
            chain.doFilter(request, response);
            return;
        } else {
            System.out.println("没有登录");
            response.sendRedirect("login.jsp");
            return;
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
