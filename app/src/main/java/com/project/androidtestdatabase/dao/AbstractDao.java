package com.project.androidtestdatabase.dao;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.project.androidtestdatabase.MyOrmHelper;

import java.net.ContentHandler;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by LingChen on 2016/12/4.
 */

public abstract class AbstractDao<T> implements IDao<T> {

    public Dao<T, Integer> getDao() {
        return dao;
    }

    public void setDao(Dao<T, Integer> dao) {
        this.dao = dao;
    }

    private Dao<T, Integer> dao;

    public AbstractDao(Context context, Class<T> cls) {
        try {
            this.dao = MyOrmHelper.getInstance(context).getDao(cls);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean add(T t) {
        if (dao == null) {
            return false;
        }
        int ret = 0;
        try {
            ret = dao.create(t);
            Log.d("ormlite", "add row:" + ret);
            return ret == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(T t) {
        if (dao == null) {
            return false;
        }
        try {
            int ret = dao.delete(t);
            Log.d("ormlite", "delete=" + ret);
            return ret == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int deleteIds(Collection ids) {
        if (dao == null) return 0;
        try {
            return dao.deleteIds(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteAll(String table) {
        if (dao == null) return false;
        try {
            int ret = dao.executeRaw("DELETE FROM " + table);
            Log.d("ormlite", "deleteAll rows:"+ret);
            return ret > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public  boolean update(T t) {
        if (dao == null) return false;
        try {
            int ret = dao.update(t);
            return ret == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int updateBySQL(String statement, String... arguments) {
        if (dao == null) return 0;
        try
        {
            return dao.updateRaw(statement, arguments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public T getSingleById(int id) {
        if (this.dao == null) return null;
        try {
            return this.dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List getAll() {
        if (this.dao == null) return null;
        try {
            return this.dao.queryForAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List getListByFieldAndOrderBy(Map<String, Object> fieldValues,
                                         Map<String, Boolean> orderBy) {
        if (this.dao == null) return null;
        try{
            QueryBuilder<T, Integer> queryBuilder = dao.queryBuilder();
            if (orderBy != null) {
                for(Map.Entry<String, Boolean> entry : orderBy.entrySet()){
                    queryBuilder.orderBy(entry.getKey(), entry.getValue());
                }
            }
            if (fieldValues != null) {
                Where<T, Integer> where = queryBuilder.where();
                for (Map.Entry<String, Object> entry : fieldValues.entrySet()) {
                    queryBuilder.setWhere(where);
                }
            }
            return queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
