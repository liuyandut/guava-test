package com.qunar.fresh.guava;

import com.google.common.collect.ImmutableSet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * guava ImmutableSet类学习
 *
 * Created by liuyandut@163.com on 15-7-21.
 */
public class ImmutableSetTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("a");
        list.add("v");

        //首先注意一点，由于set是immutable的，所以什么add remove
        //方法肯定就不存在啦

        //可以直接通过copyOf方法初始化一个immutableSet
        //参数类型可以为：容器/数组/Iterator/Iterable
        //ImmutableSet<String> immutableSet = ImmutableSet.copyOf(list);
        //ImmutableSet<String> immutableSet = ImmutableSet.copyOf(new String[]{"1","2"});

        //of方法初始化
        ImmutableSet<String> immutableSet = ImmutableSet.of();
        //ImmutableSet<String> immutableSet = ImmutableSet.of("1");
        //ImmutableSet<String> immutableSet = ImmutableSet.of("1","2");
        //ImmutableSet<String> immutableSet = ImmutableSet.of("1","2","3");

        //想要遍历获取其迭代器即可，或者直接for()，内部也是调用的迭代器
        Iterator iterator = immutableSet.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        for (String s : immutableSet) {
            System.out.println(s);
        }

    }
}
