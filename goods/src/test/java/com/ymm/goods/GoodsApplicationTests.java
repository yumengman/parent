package com.ymm.goods;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class GoodsApplicationTests {

  @Test
  void contextLoads() {
  }

  static volatile Map<String, Object> map = new HashMap<>(2);
  static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
  static List<Integer> list = new ArrayList<>();
  static Map<String, Object> hashTable = new Hashtable<>(2);
  static int i = 0;
  public static void main(String[] args) throws InterruptedException {
    for (i = 0; i < 10000; i++) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
//          System.out.print(i + "  ");
          String uuid = UUID.randomUUID().toString();
          concurrentHashMap.put(uuid, i);
          hashTable.put(uuid,i);
          synchronized (this){
            map.put(uuid, i);
          }
          list.add(i);
        }
      });
      thread.start();
    }

    Thread.sleep(10000L);
    System.out.println();
    System.out.println("ConcurrentHashMap：" + concurrentHashMap.size());
    System.out.println("HashMap：" + map.size());
    System.out.println("List：" + list.size());
    System.out.println("HashTable：" + hashTable.size());

  }
}
