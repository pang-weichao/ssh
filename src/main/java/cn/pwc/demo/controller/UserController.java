package cn.pwc.demo.controller;

import cn.pwc.demo.service.UserService;
import cn.pwc.demo.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author boom
 * @description 用户相关操作
 * @create 2017-05-14 16:11
 **/
@Controller
@RequestMapping("/user")
//被代理对象得同意代理
@EnableAspectJAutoProxy
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public ReturnResult login(String name, String password, HttpSession httpSession){
        Integer info = userService.login(name,password,httpSession);
        ReturnResult result = new ReturnResult();
        result.setData(info);
        if(info == -1)result.setResult("no");
        else result.setResult("ok");
        return result;
    }

    @RequestMapping("/test")
    @ResponseBody
    public ReturnResult test(){
        ReturnResult result = new ReturnResult();
        result.setResult("ok");
        return result;
    }
}
