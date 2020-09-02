package com.wjh.demo.service;

import java.util.List;

/**
 * @author WJH
 * @date 2020/7/5
 */
public interface IService<T,K,D> {
    T queryById(Integer id);

    K queryDetailById(Integer id);

    List<T> queryAll(T data);

    List<K> queryAllDetail(D dto);

    boolean insert(T data);

    boolean update(T data);

    boolean delete(Integer id);

    boolean deleteTrue(Integer id);

    boolean isExist(T data);

    boolean isExistExId(T data, int exId);
}

