package com.qunar.fresh.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Map;

/**
 * BiMap：双向键值对
 *
 * Created by liuyandut@163.com on 15-7-21.
 */
public class BiMapTest {

    public static void main(String[] args) {

        //注意BiMap的key和value都不能重复，否则inverse之后就不能保证键值一一对应了
        BiMap<String, Integer> users = HashBiMap.create();

        users.put("bandery", 10);
        users.put("ryan", 11);
        users.put("liuyan", 12);

        //反转，key变成value，value变成key
        System.out.println(users.inverse().get(10));

        //会有异常，key和value都不能重复
        //System.out.println(users.inverse().get(11));
        //异常,"bandery"已经存在
        //users.put("bandery", 1);

        //如果想插入的话，可以用forcePut强制插入，但在这之前会将相同的K或者V对应
        //的键值对删除

        //这样会把之前的bandery-10删除
        users.forcePut("bandery", 13);

        //这样会把之前的ryan-11和liuyan-12都删除
        users.forcePut("ryan", 12);

        //当然还有putAll方法
        Map<String, Integer> toadd = HashBiMap.create();
        toadd.put("aaa", 111111);
        toadd.put("bbb", 22222);
        users.putAll(toadd);
    }

}
