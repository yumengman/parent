package com.ymm.goods;

import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description     测试
 * @Date 2020-08-20 17:13
 * @Author ymm
 * @Version: v1.0
 */
public class TestHashMap {

    static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
    static Map<String, Object> map = new Hashtable<>(2);
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            String r = String.valueOf(Math.round(Math.random()*100000));
            concurrentHashMap.put(r,UUID.randomUUID().toString());
            map.put(r,UUID.randomUUID().toString());
        }

        System.out.println("concurrentHashMap:" + concurrentHashMap);
        System.out.println();
        System.out.println("hashMap:" + map);
        Long startTime = System.currentTimeMillis();
        if (concurrentHashMap.containsKey("0")){
            System.out.println("concurrentHashMap:" + concurrentHashMap.get("0").toString() + "      endTime:" + (System.currentTimeMillis() - startTime));
        }else{
            System.out.println(false);
        }
        startTime = System.currentTimeMillis();
        if (map.containsKey("0")){
            System.out.println("hashMap:" + map.get("0").toString() + "    endTime:" + (System.currentTimeMillis() - startTime));
        }else{
            System.out.println(false);
        }


    }
}
