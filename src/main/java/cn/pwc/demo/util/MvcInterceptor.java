package cn.pwc.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author boom
 * @description 拦截器
 * @create 2017-05-15 9:44
 **/
public class MvcInterceptor implements HandlerInterceptor {

    @Autowired
    private EhcacheUtil ehcacheUtil;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("session是"+httpServletRequest.getSession().getId().toString() + "      " + httpServletRequest.getRequestURL());
        HttpSession session = httpServletRequest.getSession();
        Cache cache = ehcacheUtil.getCache("loginCache");
        String type = "";
        if(httpServletRequest.getHeader("X-Requested-With") != null){
            type = httpServletRequest.getHeader("X-Requested-With");
        }
        if(cache.get(session.getId()) == null && !type.equals("XMLHttpRequest")){
            //不是通过ajax请求,直接重定向
            httpServletResponse.sendRedirect("/view/login.html");
            return false;
        }else if(cache.get(session.getId()) == null && type.equals("XMLHttpRequest")){
            httpServletResponse.setHeader("SESSIONSTATUS","TIMEOUT");
            httpServletResponse.setHeader("CONTEXTPATH","/view/login.html");
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }else{
            System.out.println("通过");
            return true;
        }
//        cache.put(session.getId(),session.getAttribute("userId"));
        //这里为ture，让他进入后面的处理
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
