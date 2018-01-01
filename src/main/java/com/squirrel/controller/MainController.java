package com.squirrel.controller;

import com.squirrel.pojo.User;
import com.squirrel.service.UserService;
import com.squirrel.util.UserGrid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainController {

    @Resource
    private UserService userService;
    @RequestMapping(value = "/api/v1/users")
    @ResponseBody
    public UserGrid getUserList(@RequestParam(value = "page",required = false) Integer page,
                                @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                @RequestParam(value = "username",required = false) String username) {
        System.out.println("username:"+username);
        int total = userService.getUserNum();
        String pageStr = page + "";
        String pageSizeStr = pageSize + "";
        if("".equals(pageStr))
            page = 1;
        if("".equals(pageSizeStr))
            pageSize = 10;
        List<User> data = userService.getPageUser(1,10);
        System.out.println("data:"+data.size());
        UserGrid userGrid = new UserGrid();
        userGrid.setRows(data);
        userGrid.setTotal(total);
        return userGrid;
    }
}
