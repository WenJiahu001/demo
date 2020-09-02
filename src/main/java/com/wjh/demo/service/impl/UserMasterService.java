package com.wjh.demo.service.impl;

import com.wjh.demo.exception.ServiceException;
import com.wjh.demo.service.IService;
import com.wjh.demo.entity.UserMaster;
import com.wjh.demo.entity.vo.UserMasterVO;
import com.wjh.demo.entity.dto.UserMasterDTO;
import com.wjh.demo.dao.impl.UserMasterDao;
import com.wjh.demo.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import tk.mybatis.mapper.entity.Example;

/**
 * 账号表(UserMaster)表Service实现类
 *
 * @author wjh
 * @since 2020-08-31 14:48:37
 */
@Service
public class UserMasterService implements IService<UserMaster,UserMasterVO,UserMasterDTO> {
    @Autowired
    private UserMasterDao userMasterDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserMaster queryById(Integer id) {
        return this.userMasterDao.selectByPrimaryKey(id);
    }

    /**
     * 通过ID查询单条数据详情
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserMasterVO queryDetailById(Integer id) {
        return this.userMasterDao.selectDetail(id);
    }

    /**
     * 查询所有数据
     *
     * @param 
     * @return 对象列表
     */
    @Override
    public List<UserMaster> queryAll(UserMaster userMaster) {
        return this.userMasterDao.select(userMaster);
    }

    /**
     * 查询所有数据 多表
     *
     * @param
     * @return 对象列表
     */
    @Override
    public List<UserMasterVO> queryAllDetail(UserMasterDTO userMasterDTO) {
        return this.userMasterDao.selectLi(userMasterDTO);
    }
    /**
     * 新增数据
     *
     * @param userMaster 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(UserMaster userMaster) {
        long now = DateUtils.getCurrentTime();
        userMaster.setCreateTime(now);
        userMaster.setModifyTime(now);
        int i = userMasterDao.insertSelective(userMaster);
        if(i==0) throw new ServiceException("账号表插入异常");
            
        return userMasterDao.insertSelective(userMaster) > 0;
    }

    /**
     * 修改数据
     *
     * @param userMaster 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(UserMaster userMaster) {
        long now = DateUtils.getCurrentTime();
        userMaster.setModifyTime(now);
        int i = userMasterDao.updateByPrimaryKeySelective(userMaster);
        if(i==0) throw new ServiceException("账号表修改异常");
        return i > 0;
    }

    /**
     * 通过主键删除数据(假删除)
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean delete(Integer id) {
        UserMaster userMaster = new UserMaster();
        userMaster.setId(id);
        userMaster.setStatus((byte) 0);
        int i = userMasterDao.updateByPrimaryKeySelective(userMaster);
        
        if(i==0) throw new ServiceException("账号表删除异常");
        
        return i>0;
    }
    
    /**
     * 通过主键删除数据(真删除)
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteTrue(Integer id) {
        int i = userMasterDao.deleteByPrimaryKey(id);
        if(i==0) throw new ServiceException("账号表删除异常");
        return i>0;
    }
    
    /**
     * 判断是否存在
     *
     * @param userMaster
     * @return 是否存在
     */
    @Override
    public boolean isExist(UserMaster userMaster) {
        userMaster.setStatus((byte) 1);
        Example exa = new Example(UserMaster.class);
        exa.createCriteria().andEqualTo(userMaster);
        return userMasterDao.selectOneByExample(exa) != null;
    }
    
    /**
     * 判断是否存在 排除id 一般修改的时候用
     *
     * @param userMaster
     * @param exId 排除的id
     * @return 是否存在
     */
    @Override
    public boolean isExistExId(UserMaster userMaster, int exId) {
        userMaster.setStatus((byte) 1);
        Example exa = new Example(UserMaster.class);
        exa.createCriteria().andNotEqualTo("id", exId).andEqualTo(userMaster);
        return userMasterDao.selectOneByExample(exa) != null;
    }
}