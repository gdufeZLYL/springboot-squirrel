package com.squirrel.service;

import com.squirrel.pojo.User;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    void addUser(User user);
    User getUserByPhone(String phone);
    void updateUserName(User user);
    int updateGoodsNum(Integer id,Integer goodsNum);
    User selectByPrimaryKey(Integer id);
    List<User> getPageUser(int pageNum,int pageSize);
    int getUserNum();
    InputStream getInputStream() throws Exception;

    Map<String, Object> getUsers(int pageNum, int pageSize);

    boolean updateUserById(User user);

    boolean deleteUserById(int id);

    boolean freezeUser(int id);

    boolean unfreezeUser(int id);

    List<User> getUsersByIds(List<Integer> ids);

    List<User> getUsersByIds(Set<Integer> ids);
}