/**
 * 版权所有, 
 * Author: 郭 荣誉出品
 * copyright: 2018
 */
package com.design.graduation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.design.graduation.util.ReturnData;

/**
 * @className: com.design.graduation.controller.RestController
 * @description: TODO - 
 * @author: 郭伟强   E-mail:gwq20521@163.com
 * @createTime: 2018年3月9日 上午11:32:10 
 * @version: v 1.0
 * @since 
 *
 */
@Controller
@RequestMapping({ "/rest" })
public class RestController {
    private Logger logger = Logger.getLogger(getClass().getName());

    @RequestMapping({ "/login" })
    public String login(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            return "redirect:/rest/main";
        }
        return "rest/login";
    }

    @RequestMapping({ "/404" })
    public String error404() {
        return "rest/404";
    }

    @RequestMapping({ "/401" })
    public String error401() {
        return "rest/401";
    }

    @RequestMapping({ "/500" })
    public String error500() {
        return "rest/500";
    }

    @RequestMapping({ "/main" })
    public String main() {
        Subject subject = SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            return "rest/login";
        }
        return "index";
    }

    @RequestMapping({ "/povertyAnalysis" })
    public String povertyAnalysis() {
        Subject subject = SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            return "rest/login";
        }
        return "/povertyAnalysis";
    }

    @RequestMapping({ "/welcome" })
    public String welcome() {
        return "rest/welcome";
    }

    @RequestMapping(value = { "/loginAction" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
    public String loginAction(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Subject subject = SecurityUtils.getSubject();

            subject.login(new UsernamePasswordToken(username, password));

            return "redirect:/rest/main";
        }
        catch (AuthenticationException e) {
            model.addAttribute("errormessage", e.getMessage());
        }
        return "/rest/login";
    }

    @RequestMapping({ "/loginByAjax" })
    @ResponseBody
    public ReturnData loginByAjax(HttpServletRequest request) {
        String username = request.getParameter("loginname");
        String password = request.getParameter("password");

        ReturnData rd = new ReturnData();
        try {
            Subject subject = SecurityUtils.getSubject();

            if (subject.isAuthenticated()) {
                rd.setCode("OK");
                rd.setMsg("登录成功");
            }

            subject.login(new UsernamePasswordToken(username, password));

            rd.setCode("OK");
            rd.setMsg("登录成功");
        }
        catch (AuthenticationException e) {
            this.logger.error(e.getMessage());
            rd.setCode("ERROR");
            rd.setMsg(e.getMessage());
        }
        return rd;
    }

    @RequestMapping(value = { "/logoutAction" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
    public String logoutAction(HttpSession session) {
        session.removeAttribute("userInfo");

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "rest/login";
    }
}
