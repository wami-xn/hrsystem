package com.wami.project.hrsystem.core.Utils;

import java.util.List;

public class StringHandler {
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
