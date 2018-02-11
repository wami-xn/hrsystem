package com.wami.project.hrsystem.core.utils.test;

import com.wami.project.hrsystem.core.utils.TimeClassHandler;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class TestTimeClassHandler {
    @Test
    public void testGetNumber(){
        System.out.println(TimeClassHandler.getDayOfMonth(new Date()));
        System.out.println(TimeClassHandler.getDayOfWeek(new Date()));
        System.out.println(new Date());
        System.out.println(TimeClassHandler.toString(new Date()));
        System.out.println(Arrays.toString(TimeClassHandler.getTime(new Date())));
    }
}
