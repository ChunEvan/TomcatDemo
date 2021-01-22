package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/index.jsp") || requestURI.contains("/ServletDemo1")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                request.setAttribute("login_msg", "not login");
                request.getRequestDispatcher("/ServletDemo2").forward(request,servletResponse);
            }
        }
        System.out.println("doFilter start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("doFilter back");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
