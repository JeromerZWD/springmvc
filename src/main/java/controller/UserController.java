package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class    UserController {
    @Autowired
     UserService userService;
    @RequestMapping("/list1")
    public String list(HttpServletRequest request){
        List<User> users=userService.getAll();
        request.setAttribute("list",users);
        return "list";
    }
    @RequestMapping("/testid")
    public String test(Model model,Integer id){
        System.out.println("获取页面的参数"+id);
        model.addAttribute("ids",id);
        return "success";
    }
    @RequestMapping("/testparam")
    public String testParam(@RequestParam("username") String name,@RequestParam(value = "age",required = false,defaultValue = "0") int age){
        System.out.println("获取参数"+name+","+age);
        return "success";
    }
    @RequestMapping("/testpojo")
    public String testpojo(User user,Model model){
        System.out.println(user);
        userService.saveUser(user);
        model.addAttribute("username",user.getUsername());
        return "login";
    }

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginCheck(String username,String password,HttpServletRequest request){
        User user=userService.login(username,password);
        if (user!=null){
            request.setAttribute("msg","登陆成功");
            request.getSession().setAttribute("user",user);
            return "redirect:main";
        }else{
            request.setAttribute("msg","账号或密码错误");
            return "login";
        }
    }
    @RequestMapping("/test")
    public String test(){
        System.out.println("测试控制器");
        return "success";
    }
    @RequestMapping("/main")
    public String main(){
        return  "main";
    }
}
