package com.project.androidtestdatabase.bean;

import java.lang.reflect.Field;

import javax.xml.datatype.DatatypeConstants;

/**
 * Created by LingChen on 2016/12/4.
 */

public class AbsBean {

    @Override
    public String toString() {
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        for (int idx = 0, max = fields.length; idx < max; idx++) {
            Field field = fields[idx];
            field.setAccessible(true);
            sb.append(field.getName() + "=");
            try {
                sb.append(field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (idx < max - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
