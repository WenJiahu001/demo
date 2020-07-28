package com.wjh.demo.service;

import java.util.List;

/**
 * @author WJH
 * @date 2020/7/5
 */
public interface IService<T,K> {
    T queryById(Integer id);

    K queryDetailById(Integer id);

    List<T> queryAll(T queryParam);

    List<K> queryAllDetail(T queryParam);

    boolean insert(T data);

    boolean update(T data);

    boolean delete(Integer id);

    boolean isExist(T data);

    boolean isExistExId(T data, int exId);
}
