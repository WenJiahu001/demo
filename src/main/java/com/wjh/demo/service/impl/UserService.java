package com.wjh.demo.service.impl;

import com.wjh.demo.service.IService;
import com.wjh.demo.entity.User;
import com.wjh.demo.dao.impl.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import tk.mybatis.mapper.entity.Example;
import com.wjh.demo.utils.DateUtils;

/**
 * 账号表(User)表Service实现类
 *
 * @author wjh
 * @since 2020-07-27 17:51:08
 */
@Service
public class UserService implements IService<User> {
    @Autowired
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     *
     * @param 
     * @return 对象列表
     */
    @Override
    public List<User> queryAll(User user) {
        return this.userDao.select(user);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean  insert(User user) {
        long now = DateUtils.getCurrentTime();
        user.setCreatetime(now);
        user.setModifytime(now);
        user.setStatus((byte) 1);
        return userDao.insertSelective(user) > 0;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(User user) {
        long now = DateUtils.getCurrentTime();
        user.setModifytime(now);
        int i = userDao.updateByPrimaryKeySelective(user);
        return i > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean delete(Integer id) {
        User user = new User();
        user.setId(id);
        user.setStatus((byte) 0);
        return userDao.updateByPrimaryKeySelective(user) > 0;
    }
    
    /**
     * 判断是否存在
     *
     * @param user
     * @return 是否存在
     */
    @Override
    public boolean isExist(User user) {
        Example exa = new Example(User.class);
        exa.createCriteria().andEqualTo(user);
        return userDao.selectOneByExample(exa) != null;
    }
    
    /**
     * 判断是否存在 排除id 一般修改的时候用
     *
     * @param user
     * @param exId 排除的id
     * @return 是否存在
     */
    @Override
    public boolean isExistExId(User user, int exId) {
        Example exa = new Example(User.class);
        exa.createCriteria().andNotEqualTo("id", exId).andEqualTo(user);
        return userDao.selectOneByExample(exa) != null;
    }
}