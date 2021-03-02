package leetcode.map;

import java.util.HashSet;
import java.util.Set;

/**
 * 202.快乐数
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/19
 * @since LeetCode 1.0.0
 */
public class No202IsHappy {

    //方法一：用hash集合检测循环点
    //空间复杂度 logN
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int y = n % 10;
            n = n / 10;
            sum += y * y;
        }
        return sum;
    }

    //快慢双指针检测 空间复杂度 1
    public boolean isHappy1(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }


}
