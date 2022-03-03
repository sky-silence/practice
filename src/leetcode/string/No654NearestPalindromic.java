package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 654.寻找最近回文数
 *
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 *
 * “最近的”定义为两个整数差的绝对值最小。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = "123"
 * 输出: "121"
 * 示例 2:
 *
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 *
 * @author chengzeshan
 * @version 1.0, 2022/03/02
 * @since practice 1.0.0
 */
public class No654NearestPalindromic {

    public static void main(String[] args) {
        System.out.println(3/10);
        // StringBuffer sb = new StringBuffer(s);
        // System.out.println(sb.reverse().toString());
        // System.out.println(nearestPalindromic("1837722381"));
    }

    public static String nearestPalindromic(String n) {
        //个位数特殊处理
        if (n.length() <= 1){
            return String.valueOf(Long.parseLong(n) -1);
        }

        String ans = null;
        Long min = Long.MAX_VALUE;
        Long src = Long.parseLong(n);
        Integer len = n.length();
        //10 100 1000 ...特殊处理
        if ((long)Math.pow(10d,len.doubleValue()-1) == src || (long)Math.pow(10d,len.doubleValue()-1) == src -1 ){
            return Long.valueOf((long)Math.pow(10d,len.doubleValue()-1) - 1).toString();
        }

        //99 999 999 ...特殊处理
        System.out.println((long)Math.pow(10d,len.doubleValue()));
        if ((long)Math.pow(10d,len.doubleValue()) == src + 1 ){
            return Long.valueOf((long)Math.pow(10d,len.doubleValue()) +1).toString();
        }


        boolean isOdd = true;
        List<Long> tarList = new ArrayList<>();
        List<String> tarString = new ArrayList<>();
        Long temp = 0l;
        if (len %2 == 1){
            temp = Long.parseLong(n.substring(0,len/2+1));
        }else {
            temp = Long.parseLong(n.substring(0,len/2));
            isOdd = false;
        }
        //取一半N ，取N+1 N-1 得对应回文比较
        tarList.add(temp);
        tarList.add(temp-1);
        tarList.add(temp+1);
        for (Long aLong : tarList) {
            if (isOdd){
                tarString.add(aLong.toString() + new StringBuffer(aLong.toString()).reverse().toString().substring(1));
            }else {
                tarString.add(aLong.toString() + new StringBuffer(aLong.toString()).reverse().toString());

            }
        }
        for (String s : tarString) {
            if (Math.abs(Long.parseLong(s)-src) < min && !src.toString().equals(s)){
                min = Math.abs(Long.parseLong(s)-src);
                ans = s;

                //"1837722381" case
            }else if (Math.abs(Long.parseLong(s)-src) == min && Long.valueOf(s) < Long.valueOf(ans)){
                ans = s;
            }
        }



        return ans;
    }
}
