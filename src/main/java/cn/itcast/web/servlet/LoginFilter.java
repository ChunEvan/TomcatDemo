package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {
    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WWB-INF/classes/a.txt ");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                list.add(line);
            }
            bufferedReader.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest request = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(servletRequest, args);
                    if (value!=null){
                        for (String str:list){
                            if (value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest, args);
            }
        });
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
