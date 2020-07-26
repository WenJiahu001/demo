package com.wjh.demo.service;

import java.util.List;

/**
 * @author WJH
 * @date 2020/7/5
 */
public interface IService<T> {
    T queryById(Integer id);

    List<T> queryAll(T queryParam);

    boolean insert(T data);

    boolean update(T data);

    boolean delete(int id);
}
