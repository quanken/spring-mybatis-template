package com.quanken.web;

import com.quanken.entity.User;
import com.quanken.service.AuthService;
import com.quanken.web.util.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/account/user")
public class UserController{
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "")
    public String listView() {
        return "account/userList";
    }

    @ResponseBody
    @RequestMapping(value = "/list.json")
    public List list(PageForm pageForm) throws ParseException {
        long start = System.currentTimeMillis();
        List<User> users = authService.queryByDeptCode("", pageForm.toPageBounds());
        long duration = System.currentTimeMillis() - start;
        System.out.println("total cost : " + duration + " ms");
        return users;
    }


    @RequestMapping(value = "/jstl.action")
    public String usersView(PageForm pageForm, HttpServletRequest request) throws ParseException {
        List users = list(pageForm);
        request.setAttribute("users", users);
        return "account/jstl";
    }


}
