package cn.itcast.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class ServletDemo2 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println(req.getMethod());
        System.out.println(req.getContextPath());
        System.out.println(req.getServletPath());
        System.out.println(req.getQueryString());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getProtocol());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getHeader("referer"));
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement()+"="+req.getHeader(""+headerNames.nextElement()));
        }

        req.setAttribute("name","evan");
        Object name = req.getAttribute("name");
        req.removeAttribute("name");
        req.getRequestDispatcher("/demo1").forward(req,resp);
        ServletContext servletContext = this.getServletContext();
        servletContext.getMimeType("a.jpg");
        HttpSession session = req.getSession();
        session.setAttribute("xxx","dgasgsa");
        Object xx = session.getAttribute("xxx");
        Cookie cookie = new Cookie("SESSSIONID",  session.getId());

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie2: cookies){
            String name1 = cookie2.getName();
            String value = cookie2.getValue();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
//        System.out.println(req);
    }
}
