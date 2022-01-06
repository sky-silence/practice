package leetcode.math;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 * @author chengzeshan
 * @version 1.0, 2021/12/31
 * @since practice 1.0.0
 */
public class No507CheckPerfectNumber {

    public static boolean checkPerfectNumber(int num) {
        if (num ==1) return false;
        int ans = 1;
        for (int i = 2 ; i * i < num; i++){
            if (num % i ==0){
                ans += i;
                if (i * i < num){
                    ans += num/i;
                }
            }
        }
        return ans == num;
    }
}
