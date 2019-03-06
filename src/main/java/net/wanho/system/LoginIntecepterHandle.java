package net.wanho.system;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntecepterHandle implements HandlerInterceptor {


    //api执行之前
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)");


        Object object = httpServletRequest.getSession().getAttribute("user");

        if(object==null)
        {
            httpServletResponse.sendRedirect("/login.jsp");
            return false;
        }


        return true;
    }

    //api执行之后，页面渲染之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)");
    }

    //api执行之后，页面渲染之后
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)");
    }
}
