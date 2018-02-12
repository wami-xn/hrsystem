package com.wami.project.hrsystem.core.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiltingHandler {
     public static Map<Object, Object> listToMap(List<Object> list, String id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
         Map<Object, Object> map = new HashMap<>();
         for (Object obj: list){
             Method method = obj.getClass().getMethod(id);
             Object object = method.invoke(obj);
             map.put(object, obj);
         }
         return map;
     }
     public static List<Object> getValues( Map<Object, Object>  map){
         List<Object> list = new ArrayList<>();
         for(Map.Entry entry: map.entrySet()){
             list.add(entry.getValue());
         }
         return list;
     }
    public static List<Object> getKeys( Map<Object, Object>  map){
        List<Object> list = new ArrayList<>();
        for(Map.Entry entry: map.entrySet()){
            list.add(entry.getKey());
        }
        return list;
    }
}
