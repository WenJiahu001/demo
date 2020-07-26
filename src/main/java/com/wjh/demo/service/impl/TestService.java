package com.wjh.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wjh.demo.dao.impl.TestDao;
import com.wjh.demo.entity.User;
import com.wjh.demo.service.IService;
import com.wjh.demo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ClassName:UserService
 * Package:
 *
 * @Date:2020/7/26 20:57
 * @Author:WenJiahu
 */
@Service
public class TestService implements IService<User> {
    @Autowired
    TestDao userDao;

    @Override
    public User queryById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public List<User> queryAll(User user) {
        return userDao.select(user);
    }

    @Override
    public boolean insert(User insData) {
        long now = DateUtils.getCurrentTime();
        insData.setCreatetime(now);
        insData.setModifytime(now);
        insData.setStatus((byte) 1);
        return userDao.insertSelective(insData) > 0;
    }

    @Override
    public boolean update(User updData) {
        long now = DateUtils.getCurrentTime();
        updData.setModifytime(now);
        System.out.println(JSONObject.toJSONString(updData));
        int i = userDao.updateByPrimaryKeySelective(updData);
        System.out.println(i);
        return i > 0;
    }

    @Override
    public boolean delete(int id) {
        User data = new User();
        data.setId(id);
        data.setStatus((byte) 0);
        return userDao.updateByPrimaryKeySelective(data) > 0;
    }

    public boolean isExist(User user) {
        Example exa = new Example(User.class);
        exa.createCriteria().andEqualTo(user);
        User user1 = userDao.selectOneByExample(exa);
        System.out.println(JSONObject.toJSONString(user1));
        return user1 != null;
    }

    public boolean isExistExId(User user, int exId) {
        Example exa = new Example(User.class);
        exa.createCriteria().andNotEqualTo("id", exId).andEqualTo(user);
        return userDao.selectOneByExample(exa) != null;
    }
}
