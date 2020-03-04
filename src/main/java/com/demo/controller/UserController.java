package com.demo.controller;

import com.demo.pojo.Users;
import com.demo.service.UserService;
import com.demo.utils.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("toLogin.do")
    public String toLoginInterface(){
        return "login";
    }

    @RequestMapping("index.do")
    public String index(){
        return "index";
    }

    @RequestMapping("nofunc.do")
    public String nofunc(){
        return "nofunc";
    }

    @RequestMapping("roleManage.do")
    public String roleManage(){
        return "roleManage";
    }

    @RequestMapping("addUser.do")
    public String addUser(){
        return "addUser";
    }

    @RequestMapping("login.do")
    public String doLogin(HttpServletRequest request) {
       /* String account = request.getParameter("account");
        String password = request.getParameter("password");
        if((account!=null&&!"".equals(account))&&(password!=null&&!"".equals(password))){
            Users user = userService.login(account);
            password = EncryptUtil.encryptMD5(password);
            System.out.println(password);
            if(user != null && user.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                request.setAttribute("msg","登录成功");
                return "success";
            }else{
                request.setAttribute("msg","用户名错误或密码不正确");
                return "login";
            }
        }
        request.setAttribute("msg","用户名或密码不能为空");
        return "login";
    }*/
        /*21232f297a57a5a743894a0e4a801fc3
          21232f297a57a5a743894a0e4a801fc3 */
        String username = request.getParameter("account");
        String password = request.getParameter("password");
        /*System.out.println("账户为："+username+",密码为："+password);*/
       /* password = EncryptUtil.encryptMD5(password);
        System.out.println("新密码为："+password);*/
        //获取当前的主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建用户登录令牌

        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            boolean flag = subject.isAuthenticated();
            if(flag){//验证通过
                //验证通过之后 把用户信息存放到session中
                Users user = (Users)subject.getPrincipal();
                subject.getSession().setAttribute("user",user);
                System.out.println("登录成功");
                return "success";
            }else{
              /*  request.setAttribute("msg","用户名或密码输入错误");*/
                System.out.println("密码错误");
                return "login";
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("账号不存在");
            return "login";
        }
    }
}
