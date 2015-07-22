package com.qunar.fresh.commonslang3;

import com.qunar.fresh.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * commons-lang3里面常用的字符串处理类StringUtils 特点就是字符串操作都是null safe的 里面提供的都是静态成员变量或者方法
 *
 * Created by liuyandut@163.com on 15-7-22.
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        // 常用的静态成员变量
        // StringUtils.EMPTY;
        // StringUtils.LF;
        // StringUtils.SPACE;

        // 返回字符串的缩略形式，这个方法比较常用
        // 返回 "卖..."
        // 规则是后面跟上3个省略号
        // int参数必须>=4 否则就会抛出异常
        String abbreviation = StringUtils.abbreviate("卖女孩的小火柴", 4);

        // 也可以设置左偏移值，再做缩略处理
        // 这里的工作原理暂时没搞明白
        // 这种情况一般用不上，一般都是显示前面的定长字符串加上省略号
        // StringUtils.abbreviate("string_string", 1, 7);

        // 返回两个字符串的不同的子串，策略是从两者不同的地方开始，返回第二个字符串
        // 的剩下部分
        // 注意null ""这两个特殊情况的比较：
        System.out.println(StringUtils.difference("", ""));// ""
        System.out.println(StringUtils.difference(null, null));// null
        System.out.println(StringUtils.difference("", null));// ""
        System.out.println(StringUtils.difference(null, ""));// ""
        System.out.println(StringUtils.difference("ab", "abc"));// "c"
        System.out.println(StringUtils.difference("abc", "ab"));// ""
        System.out.println(StringUtils.difference("ab", "xy"));// "xy"

        // 返回两个字符串首次不同的index
        // 相等的话返回-1
        System.out.println(StringUtils.indexOfDifference("", ""));// -1
        System.out.println(StringUtils.indexOfDifference(null, null));// -1
        System.out.println(StringUtils.indexOfDifference("", null));// 0
        System.out.println(StringUtils.indexOfDifference(null, ""));// 0
        System.out.println(StringUtils.indexOfDifference("ab", "ab"));// -1
        System.out.println(StringUtils.indexOfDifference("abc", "ab"));// 2
        System.out.println(StringUtils.indexOfDifference("ab", "abc"));// 2
        System.out.println(StringUtils.indexOfDifference("ab", "cd"));// 0

        // 还可以以字符串数组的形式进行比较，策略根上面的是一样的
        System.out.println(StringUtils.indexOfDifference(new String[] { "abc", "acdf", "addddd" }));

        // 获得字符串的公共前缀
        System.out.println(StringUtils.getCommonPrefix("", ""));// ""
        System.out.println(StringUtils.getCommonPrefix(null, null));// ""
        System.out.println(StringUtils.getCommonPrefix("", null));// ""
        System.out.println(StringUtils.getCommonPrefix(null, ""));// ""
        System.out.println(StringUtils.getCommonPrefix("avb", "avfg"));// "av"
        System.out.println(StringUtils.getCommonPrefix(new String[] { "aaa", "abbb", "accc" }));// "a"

        // 是否以某个子串开头
        // 同样的，都提供endsWith相同的功能
        System.out.println(StringUtils.startsWith("abcd", "a"));
        System.out.println(StringUtils.startsWithIgnoreCase("ABCD", "a"));
        System.out.println(StringUtils.startsWithAny("abcd", new String[] { "b", "a" }));

        System.out.println(StringUtils.normalizeSpace("ab cd e "));

        // 计算字符串的编辑距离，也叫Levenshtein距离。
        // 比如abcd -> afcde的编辑距离是2：先要把b设成f，然后再添加e
        // 典型应用场景：计算字符串相似度！！！！
        System.out.println(StringUtils.getLevenshteinDistance("abcd", "afcde"));

        // 如果字符串不是以某个子串补齐的话，则补上去
        // 注意是全补，而不是部分补
        // 同样的，也提供前面补齐的方法：prePendIfMissing(str1, str2)
        System.out.println(StringUtils.appendIfMissing("abc", "cf")); // abccf
        System.out.println(StringUtils.appendIfMissingIgnoreCase("abC", "cf")); // abCcf
        System.out.println(StringUtils.appendIfMissingIgnoreCase("abCF", "cf")); // abCF

        // 指定编码方式生成字符串
        // StringUtils.toEncodedString(byte[], charset);
    }
}
