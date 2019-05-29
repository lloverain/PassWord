package com.yangjiaying.controller;

import com.yangjiaying.Servlet.VerificationImpl;
import com.yangjiaying.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class login {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(user user, HttpSession session){
        VerificationImpl verification = new VerificationImpl();
        int num =  verification.login(user);
        if(num!=0){
            session.setAttribute("name",user.getUsername());
            return "redirect:remenber";
        }else {
            return "login";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String tologin(){
        return "login";
    }

    @RequestMapping(value = "/remenber")
    public String tomain(){
        return "remenber";
    }

    @RequestMapping(value = "/tuichu")
    public String tuichu(HttpSession session){
        session.removeAttribute("name");
        return "redirect:login";
    }
}
