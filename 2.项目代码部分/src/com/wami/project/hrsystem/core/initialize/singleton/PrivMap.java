package com.wami.project.hrsystem.core.initialize.singleton;

import java.util.Map;

public class PrivMap {
    private volatile static PrivMap instance = new PrivMap();
    private PrivMap(){

        PRIVMAP =
    }

    public static PrivMap getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new PrivMap();
                }
            }
        }
        return instance;
    }
    private Map<Long, String> PRIVMAP;

    public Map<Long, String>getPrivList() {
        return PRIVMAP;
    }
}

