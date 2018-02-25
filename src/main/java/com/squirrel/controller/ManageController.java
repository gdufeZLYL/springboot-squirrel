package com.squirrel.controller;

import com.squirrel.common.GgeeConst;
import com.squirrel.dto.AjaxResult;
import com.squirrel.pojo.User;
import com.squirrel.service.UserService;
import com.squirrel.util.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/manage")
public class ManageController {

    @Resource
    private UserService userService;

    /**
     * 管理员登录页
     */
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        User currentUser = (User) request.getSession().getAttribute(GgeeConst.CUR_USER);
        model.addAttribute(GgeeConst.CUR_USER, currentUser);
        if (currentUser == null) {
            return "/manage/manage-login";
        } else {
            return "redirect:/manage/user/list";
        }
    }

    /**
     * 用户管理
     */
    @RequestMapping(value="/user/list", method= RequestMethod.GET)
    public String userList(HttpServletRequest request,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              Model model) {
        User currentUser = (User) request.getSession().getAttribute(GgeeConst.CUR_USER);
        model.addAttribute(GgeeConst.CUR_USER, currentUser);
        if (currentUser == null || currentUser.getPower() != 90) {
            return "404";
        } else {
            Map<String, Object> data = userService.getUsers(page, GgeeConst.userPageSize);
            model.addAttribute(GgeeConst.DATA, data);
            return "/manage/manage-userList";
        }
    }

    /**
     * 商品管理
     */
    @RequestMapping(value="/user/list", method= RequestMethod.GET)
    public String goodsList(HttpServletRequest request,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           Model model) {
        User currentUser = (User) request.getSession().getAttribute(GgeeConst.CUR_USER);
        model.addAttribute(GgeeConst.CUR_USER, currentUser);
        if (currentUser == null || currentUser.getPower() != 90) {
            return "404";
        } else {
            Map<String, Object> data = userService.getUsers(page, GgeeConst.userPageSize);
            model.addAttribute(GgeeConst.DATA, data);
            return "/manage/manage-goodsList";
        }
    }

    /**
     * TODO::商品审核管理
     */


}
