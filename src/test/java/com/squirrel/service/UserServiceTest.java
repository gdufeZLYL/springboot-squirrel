package com.squirrel.service;

import com.squirrel.Application;
import com.squirrel.dao.UserMapper;
import com.squirrel.pojo.User;
import com.squirrel.util.DateUtil;
import com.squirrel.util.MD5;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class UserServiceTest {

    private static Log LOG = LogFactory.getLog(UserServiceTest.class);

    @Autowired
    private UserService userService;

//    @Test
//    public void addUser() throws Exception {
//        User user = new User();
//        user.setPhone("111");
//        user.setUsername("test1");
//        user.setPassword(MD5.md5("123456"));
//        user.setQq("111");
//        user.setCreateAt(DateUtil.getNowDate());
//        user.setGoodsNum(0);
//        user.setPower((byte) 10);
//        userService.addUser(user);
//    }

//    @Test
//    public void getUserByPhone() throws Exception {
//        String phone = "111";
//        User user = userService.getUserByPhone(phone);
//        LOG.info("user = " + user);
//    }
//
//    @Test
//    public void updateUserName() throws Exception {
//        String username = "test";
//        String phone = "111";
//        User user = userService.getUserByPhone(phone);
//        user.setUsername(username);
//        userService.updateUserName(user);
//    }
//
//    @Test
//    public void updateGoodsNum() throws Exception {
//        String phone = "111";
//        User user = userService.getUserByPhone(phone);
//        user.setGoodsNum(1);
//        userService.updateGoodsNum(user.getId(), user.getGoodsNum());
//    }
//
//    @Test
//    public void selectByPrimaryKey() throws Exception {
//        User user = userService.selectByPrimaryKey(6);
//        LOG.info("user = " + user);
//    }
//
//    @Test
//    public void getPageUser() throws Exception {
//        List<User> users = userService.getPageUser(2, 2);
//        for (User user : users) {
//            LOG.info("user = " + user);
//        }
//    }
//
//    @Test
//    public void getUserNum() throws Exception {
//        int num = userService.getUserNum();
//        LOG.info("num = " + num);
//    }
//
//    @Test
//    public void getInputStream() throws Exception {
//    }

}