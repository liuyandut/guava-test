package com.qunar.fresh.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * guava Ordering比较器：
 * 由于是一个implements Comparator的抽象类，所有
 * 可以把它当成一个特殊的Comparator。
 * 所以在Collections.sort(list, Comparator)中完全可以直接使用它。
 *
 * Created by liuyandut@163.com on 15-7-21.
 */
public class OrderingTest {
    public static void main(String[] args) {
        //guava的static constructor
        List<Integer> list = Lists.newArrayList();

        //测试容器
        Random rd = new Random(System.currentTimeMillis());
        list.add(5);
        list.add(4);
        list.add(null);
        list.add(10);
        list.add(10);
        list.add(-1);

        //排序前展示
        System.out.println("排序前："+list);

        //声明一个倒序的自然排序的Ordering instance，且null在前面
        //支持链式方法调用
        Ordering order1 = Ordering.natural()
                .nullsFirst()
                .reverse();
        //利用定义好的排序规则对list进行排序
        Collections.sort(list, order1);

        //排序前与排序后的对比
        System.out.println("排序后："+list);


        //对根据Ordering特定规则排完序的list进行二分查找
        //前提是必须是排好序的
        System.out.println("二分查找10的位置："+order1.binarySearch(list, 10));
        //注意对不存在的元素的查找，jdk的实现中只保证结果为负，而不一定是-1.
        System.out.println("二分查找0的位置："+order1.binarySearch(list, 0));

        //对排序结果的拷贝,相当于执行了两步：
        //1 Collections.sort(list, order1);
        //2 newlist = list.clone()
        List<Integer> copyList = order1.sortedCopy(list);

        //对sortedCopy的扩展：
        //返回一个immutable特性的list
        //注意：有null的话会报错，因为ImmutableXXX不接受null
        //ImmutableList<Integer> copyImmutableList = order1.immutableSortedCopy(list);

        //判断list是否按排序方式排好序
        System.out.println("是否已排序："+order1.isOrdered(list));

        //判断list是否按排序方式排好序,并且后一个元素比前一个肯定大，相等的话就返回false
        //特殊的，忽略null
        System.out.println("是否是严格排序（前后不能相等）:"+order1.isStrictlyOrdered(list));

        //返回最大的元素，如果最大元素不止一个，则返回第一个。
        //这里需要注意以下，如果类对象equals相等，但是可能返回的对象的每个属性不一定全部
        //相同，这要看equals的具体定义
        System.out.println("最大值:" + order1.max(list));

        //最大值扩展
        //返回参数1 参数2 参数数组 这些所有的最大值,有时候将获得的临时值与原来就有
        //的数组进行比较获得最大值，可能会用到这个方法
        //这里会抛出异常，因为Integer无法识别之前定义的Ordering排序方法
        //所以这个方法使用的前提是集合元素的对象必须在定义的排序方式下有可比较性
        //System.out.println("100与list的最大值："+order1.max(new Integer(100), list));

        //返回在Ordering排序方式下面的最大值，因为此处定义的Ordering为inverse,所以
        //4是“最大值”
        System.out.println("最大值：" + order1.max(10, 4));

        //min的方法类比max


    }
}
