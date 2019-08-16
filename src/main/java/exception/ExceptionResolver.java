package exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg=null;
        //处理自定义编译类型错误
        if(e instanceof MyException){
            MyException customeExecption=(MyException)e;
            msg=customeExecption.getMessage();
            //打印异常信息
            System.out.println("产生了自定义异常："+customeExecption.getMessage());
        }else{
//系统异常
            Writer out = new StringWriter();
            PrintWriter s = new PrintWriter(out);
            e.printStackTrace(s);
            msg = out.toString();
        }
        //处理运行时异常
        ModelAndView mv=new ModelAndView();
        mv.setViewName("error");//出错了，返回错误页面
        mv.addObject("msg",msg);
        return mv;
    }
}
