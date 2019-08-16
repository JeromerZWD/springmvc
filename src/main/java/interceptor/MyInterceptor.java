package interceptor;

import entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    //在控制器执行之前的处理，返回flase,不往下执行,下一个拦截器也不执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("控制器执行之前的方法");
        String uri=request.getRequestURI();
        //URL:除了login.jsp是可以公开访问的 其他都进行拦截
        if (uri.indexOf("/login")>0){
            return true;
        }
        User user=(User)request.getSession().getAttribute("user");
        if (user!=null){
            return true;
        }
        request.setAttribute("msg","您还没有登录，请先登录");
        request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
        return false;
    }
    //控制器执行之后，但是没有返回视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("控制器执行之后的方法，但未返回视图");
    }
   //控制器执行之后，并返回了视图，之后的执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("控制器执行之后的方法，并返回视图");
    }
}
