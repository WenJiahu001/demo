package com.wjh.demo.dao;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/*
Mapper接口：基本的增、删、改、查方法
MySqlMapper：针对MySQL的额外补充接口，支持批量插入
*/
public interface MyMapper<T> extends Mapper<T>, InsertListMapper<T> {

}
