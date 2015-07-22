package com.qunar.fresh.jodatime;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Locale;

/**
 * jodaTime learning
 *
 * Created by liuyandut@163.com on 15-7-22.
 */
public class JodaTimeTest {
    public static void main(String[] args) {
        //DateTime创建一个新的日期对象的方式
        //Date zone最好指定一下，不指定的话就是机器所在的时区。

        //方式一：使用系统时间，或者使用静态方法DateTime.now()方法
        DateTime time1 = new DateTime();
        System.out.println(time1.toString("yyyy-MM-dd HH:mm:ss"));

        //dateTime.toString()是一个很有用的方法啊！直接根据给定的pattern返回日期字符串
        //pattern里面，EE表示星期，根据Locale.XXX决定哪种语言
        System.out.println(time1.toString("yyyy-MM-dd HH:mm:ss EE", Locale.CHINESE));
        System.out.println(time1.toString("yyyy-MM-dd HH:mm:ss EE", Locale.US));

        //方式二：使用多个字段（不是必须要指定到毫秒级别）指定一个瞬间时刻，最低指定到分钟级别
        DateTime time2 = new DateTime(2009,2,28,17,45,0,333);
        System.out.println(time2.toString("yyyy-MM-dd HH:mm:ss"));
        //方式三：以毫秒为单位指定一个瞬间时刻
        DateTime time3 = new DateTime(2222222222222L);
        System.out.println(time3.toString("yyyy-MM-dd HH:mm:ss"));
        //方式四：使用另一个对象
        DateTime time4 = new DateTime(time3);
        System.out.println(time4.toString("yyyy-MM-dd HH:mm:ss"));

        System.out.println("time2: "+time2.toString("yyyy-MM-dd HH:mm:ss.SSS"));

        //字符串解析
        //方式一，只需要一行
        DateTime time22 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2015-4-4");
        //方式二
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime time20 = DateTime.parse("2015-4-4", dtf);

        //返回年月日时分秒毫秒属性值
        System.out.println(time2.year().get());
        System.out.println(time2.monthOfYear().get());
        System.out.println(time2.getDayOfMonth());
        System.out.println(time2.hourOfDay().get());
        System.out.println(time2.getMinuteOfHour());
        System.out.println(time2.getMillisOfSecond());

        //分别返回在当 年/月/周 处在第几天
        System.out.println(time2.getDayOfYear());
        System.out.println(time2.getDayOfMonth());
        System.out.println(time2.getDayOfWeek());

        //日期前后计算,参数为负就是往前，当然也提供了minusXXX的方法
        //由于DateTime实现了链式方法调用，所以直接可以.m1().m2().m3()
        DateTime time5 = time2.plusYears(1);
        DateTime time6 = time2.plusYears(-1);
        DateTime time7 = time2.plusMonths(1);
        DateTime time8 = time2.plusDays(1);
        DateTime time9 = time2.plusHours(1);
        DateTime time10 = time2.plusMinutes(10);
        DateTime time11 = time2.plusSeconds(11);

        //日期的比较
        System.out.println(time2.isBefore(time3));
        System.out.println(time2.isAfter(time3));
        System.out.println(time2.isEqualNow());
        System.out.println(time3.isEqual(time4));

        //时间的差计算，年月日甚至时分秒都可以计算
        DateTime time111 = DateTime.now();
        DateTime time211 = new DateTime(2015,7,20,1,1,1);
        System.out.println("time111:"+time1.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("time211:"+time2.toString("yyyy-MM-dd HH:mm:ss"));
        //注意：
        //！！计算差的时候采取的近似是floor近似，不足两天的结果是1天
        System.out.println(Days.daysBetween(time111, time211).getDays());
        System.out.println(Months.monthsBetween(time111, time211).getMonths());
        System.out.println(Years.yearsBetween(time111, time211).getYears());


        //与Calendar的互相转换, calendar转换成datetime只能通过long
        Calendar c1 = time1.toCalendar(Locale.getDefault());

        //闰年 闰月的判断
        System.out.println("time2:"+time2);
        System.out.println("是否闰月："+time2.monthOfYear().isLeap());
        System.out.println("是否闰年："+time2.year().isLeap());

    }
}
