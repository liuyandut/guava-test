package com.qunar.fresh.guava;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyandut@163.com on 15-7-23.
 */
public class CacheTest {
    public static void main(String[] args) throws Exception {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100) // 储存的键值对最多有多少
                .expireAfterWrite(2, TimeUnit.SECONDS).removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> removalNotification) {
                        System.out.println(removalNotification.getKey() + " is removed.");
                    }
                }).recordStats().build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return ("!" + s);
                    }
                });

        // cache.put("a", "bandery");

        //继续学习

        System.out.println(cache.stats());

    }

}
