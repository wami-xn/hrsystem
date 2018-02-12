package com.wami.project.hrsystem.core.utils;

import com.wami.project.hrsystem.core.enties.functional.exception.FrequencyFormatException;

import java.sql.Timestamp;
import java.util.*;
/**
 * 内部装载的nextDate的转换实现：
 * 通过内定的frequency字符串计算出下一次时间的Date值，
 * 和通过确定的传输格式实现生成frequency字符串
 */
public class FrequencyHandler {
    /**
     * 通过内定的frequency字符串计算出下一次时间的Date值，
     */
    public static Timestamp nextDateIgnoreSysdate(String frequency, Timestamp timestamp){
        if(frequency.matches("^C:.*")){
            return circulateMapping(frequency.replace("C:", ""),timestamp);
        }else if(frequency.matches("^F:.*")){
            return fixedMapping(frequency.replace("F:", ""),timestamp);
        }else if(frequency.matches("^S:.*")){
            return singleMapping(frequency.replace("S:", ""),timestamp);
        }else {
            throw new FrequencyFormatException("无法转换类型" + frequency);
        }
    }
    private static Timestamp circulateMapping(String frequency, Timestamp timestamp){
        Long time = timestamp.getTime();
        String[] strings = frequency.split("_");
        for(String string : strings){
            String[] temp = string.split("&");
            if(temp[0].equals("w")){
                time = timestamp.getTime() + Long.valueOf(temp[1]) * 3600 * 1000 * 24 * 7;
            }
            if(temp[0].equals("d")){
                time = timestamp.getTime() + Long.valueOf(temp[1]) * 3600 * 1000 * 24;
            }
            if(temp[0].equals("h")){
                time = timestamp.getTime() + Long.valueOf(temp[1]) * 3600 * 1000;
            }
            if(temp[0].equals("m")){
                time = timestamp.getTime() + Long.valueOf(temp[1]) * 60 * 1000;
            }
            if(temp[0].equals("s")){
                time = timestamp.getTime() + Long.valueOf(temp[1]) * 1000;
            }
        }
        return new Timestamp(time);
    }
    private static Timestamp fixedMapping(String frequency, Timestamp timestamp){
        Long time = timestamp.getTime();
        String[] strings = frequency.split("_");
        Map<String, List<Integer>> stringMap = new HashMap<>();

        for(String string : strings) {
            String[] temp = string.split("&");
            String[] temp2 = temp[1].split(",");
            List<Integer> list = new ArrayList<>();
            for(String string1: temp2){
                list.add(Integer.valueOf("string1"));
            }
            stringMap.put(temp[0], list);
        }
        List<Integer> years;
        if( stringMap.get("y") != null){
            List<Integer> integerList = stringMap.get("y");
            Integer int1 = TimeClassHandler.getYear(timestamp);
            years = getSmallestOverStd(integerList, int1, 2);
        }else {
            Integer int1 = TimeClassHandler.getYear(timestamp);
            years = Arrays.asList(int1, int1+1);
        }
        List<Integer> months;
        if( stringMap.get("m") != null){
            List<Integer> integerList = stringMap.get("m");
            Integer int1 = TimeClassHandler.getYear(timestamp);
            months = getSmallestOverStd(integerList, int1, 2);
        }else {
            Integer int1 = TimeClassHandler.getYear(timestamp);
            months = Arrays.asList(int1, int1+1);
        }
        List<Integer> days;
        if( stringMap.get("d") != null){
            List<Integer> integerList = stringMap.get("d");
            Integer int1 = TimeClassHandler.getYear(timestamp);
            days = getSmallestOverStd(integerList, int1, 2);
        }else {
            Integer int1 = TimeClassHandler.getYear(timestamp);
            days = Arrays.asList(int1, int1+1);
        }
        return new Timestamp(time);
    }
    private static Timestamp singleMapping(String frequency, Timestamp timestamp){
        return null;
    }
    private static List<Integer> getSmallestOverStd(List<Integer> list, Integer std, int number){
        list.sort(Integer::compareTo);
        List<Integer> integers = new ArrayList<>();
        int flag = 0;
        for (Integer aList : list) {
            if (flag < number) {
                if (aList >= std) {
                    integers.add(aList);
                    flag++;
                }
            }
        }
        return integers;
    }
}
