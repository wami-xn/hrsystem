package com.wami.project.hrsystem.core.utils;

import java.util.List;

public class StringHandler {
    /**
     * 将一个列表转换为在sql的in中的字符串
     */
    public static String Handle(List list){
        StringBuilder stringBuffer = new StringBuilder();
        for(Object object: list){
            if (object instanceof Long | object instanceof Integer | object instanceof Double | object instanceof Short) {
                stringBuffer.append(object).append(",");
            }else {
                stringBuffer.append("'").append(object).append("',");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
        return stringBuffer.toString();
    }
}
