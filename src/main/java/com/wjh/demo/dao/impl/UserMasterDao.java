package com.wjh.demo.dao.impl;

import com.wjh.demo.entity.UserMaster;
import com.wjh.demo.entity.vo.UserMasterVO;
import com.wjh.demo.entity.dto.UserMasterDTO;
import com.wjh.demo.dao.MyMapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 账号表(UserMaster)表数据库访问层
 *
 * @author wjh
 * @since 2020-08-03 16:22:44
 */
public interface UserMasterDao extends MyMapper<UserMaster>{

    @Select("<script>" +
            "select a.* from user_master a " +
            "where a.`status`=1 " +
            "<if test='name!=null and name!=\"\"'>and a.name=#{name} </if>" +
            "<if test='pwd!=null and pwd!=\"\"'>and a.pwd=#{pwd} </if>" +
             "</script>")
    List<UserMasterVO> selectLi(UserMasterDTO userMaster);
    
    @Select("select a.* from user_master a " +
            "where a.id=#{id}")
    UserMasterVO selectDetail(Integer id);
}