package com.wjh.demo.dao.impl;

import com.wjh.demo.entity.UserMaster;
import com.wjh.demo.entity.vo.UserMasterVO;
import com.wjh.demo.dao.MyMapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 账号表(UserMaster)表数据库访问层
 *
 * @author wjh
 * @since 2020-07-28 16:02:40
 */
public interface UserMasterDao extends MyMapper<UserMaster>{

    @Select("<script>" +
            "select a.* from user_master a" +
            "where a.status=1 " +
            "<if test='name!=null and name!=\"\"'>and a.id=#{name} </if>" +
            "<if test='pwd!=null and pwd!=\"\"'>and a.id=#{pwd} </if>" +
            "<if test='status!=null'>and a.id=#{status} </if>" +
             "</script>")
    List<UserMasterVO> selectLi(UserMaster userMaster);
    
    @Select("select a.* user_master a" +
            "where a.id=#{id}")
    UserMasterVO selectDetail(Integer id);
}