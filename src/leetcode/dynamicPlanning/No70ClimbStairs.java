package leetcode.dynamicPlanning;

/**
 * 70.爬楼梯
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/01
 * @since MyLeetCode 1.0.0
 */
public class No70ClimbStairs {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n ; i ++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
