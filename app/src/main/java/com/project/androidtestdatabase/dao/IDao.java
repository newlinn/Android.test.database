package com.project.androidtestdatabase.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by LingChen on 2016/12/4.
 */

public interface IDao<T> {

    public abstract boolean add(T t);

    public abstract boolean delete(T t);

    public abstract int deleteIds(Collection<Integer> ids);

    public abstract boolean update(T t);

    public int updateBySQL(String statement, String... arguments);

    public abstract T getSingleById(int id);

    public abstract List<T> getAll();

    public List<T> getListByFieldAndOrderBy(Map<String, Object> fieldValues,
                                            Map<String, Boolean> orderBy);
}
