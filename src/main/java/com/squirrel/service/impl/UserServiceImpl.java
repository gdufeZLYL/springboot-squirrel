package com.squirrel.service.impl;

import com.github.pagehelper.PageHelper;
import com.squirrel.dao.UserMapper;
import com.squirrel.pojo.User;
import com.squirrel.service.UserService;
import com.squirrel.util.WriteExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insert(user);
        //空属性为MySQL设定默认值
        //userMapper.insertSelective(user);
    }

    public User getUserByPhone(String phone) {
        User user  = userMapper.getUserByPhone(phone);
        return  user;
    }

    public void updateUserName(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public int updateGoodsNum(Integer id,Integer goodsNum) {
        return userMapper.updateGoodsNum(id,goodsNum);
    }

    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    //获取出当前页用户
    public List<User> getPageUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);//分页核心代码
        List<User> data= userMapper.getUserList();
        return data;
    }

    //获取出用户的数量
    public int getUserNum() {
        List<User> users = userMapper.getUserList();
        return users.size();
    }

    public InputStream getInputStream() throws Exception {
        String[] title=new String[]{"序号","手机号","姓名","QQ","开通时间","商品数量","用户权限"};
        List<User> list=userMapper.getUserList();
        List<Object[]>  dataList = new ArrayList<Object[]>();
        for(int i=0;i<list.size();i++){
            Object[] obj=new Object[7];
            obj[0]=list.get(i).getId();
            obj[1]=list.get(i).getPhone();
            obj[2]=list.get(i).getUsername();
            obj[3]=list.get(i).getQq();
            obj[4]=list.get(i).getCreateAt();
            obj[5]=list.get(i).getGoodsNum();
            obj[6]=list.get(i).getPower();
            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {}
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    @Override
    public Map<String, Object> getUsers(int pageNum, int pageSize) {
        Map<String, Object> data = new HashMap<>();
        int count = userMapper.getCount();
        if (count == 0) {
            data.put("pageNum", 0);
            data.put("pageSize", 0);
            data.put("totalPageNum", 1);
            data.put("totalPageSize", 0);
            data.put("users", new ArrayList<>());
            return data;
        }
        int totalPageNum = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        if (pageNum > totalPageNum) {
            data.put("pageNum", 0);
            data.put("pageSize", 0);
            data.put("totalPageNum", totalPageNum);
            data.put("totalPageSize", 0);
            data.put("users", new ArrayList<>());
            return data;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.getUserList();
        data.put("pageNum", pageNum);
        data.put("pageSize", pageSize);
        data.put("totalPageNum", totalPageNum);
        data.put("totalPageSize", count);
        data.put("users", users);
        return data;
    }

    @Override
    public boolean updateUserById(User user) {
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public boolean deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean freezeUser(int id) {
        return userMapper.updateStatus(id, 1) > 0;
    }

    @Override
    public boolean unfreezeUser(int id) {
        return userMapper.updateStatus(id, 0) > 0;
    }

    @Override
    public List<User> getUsersByIds(List<Integer> ids) {
        return userMapper.getUsersByIds(ids);
    }

    @Override
    public List<User> getUsersByIds(Set<Integer> ids) {
        return userMapper.getUsersByIdsSet(ids);
    }
}
