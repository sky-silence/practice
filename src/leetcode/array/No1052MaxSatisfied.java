package leetcode.array;

/**
 * 1052.爱生气的书店老板
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/26
 * @since MyLeetCode 1.0.0
 */
public class No1052MaxSatisfied {

    //滑动窗口
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
        }
        int cur = 0;
        int max = 0;
        int flag = 0;
        for (int i = 0, j = 0; i < len; i++) {
            cur += customers[i];
            if (grumpy[i] == 0) {
                flag += customers[i];
            }
            if (i - j >= X) {
                cur -= customers[j];
                if (grumpy[j] == 0) {
                    flag -= customers[j];
                }
                j++;
            }

            max = Math.max(max, cur - flag);
        }
        return ans + max;
    }

    //方法二：问题转化：
    //1.我们可以将原本就满意的客户加入答案，同时将对应的customer[i]变为0；
    //2.之后的问题转化为：在customer中找到连续一段长度为x的子数组，使得其总和最大。这部分就是我们使用技巧所得到的用户
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0;
        int max = 0;
        for (int i = 0, j = 0; i < len; i++) {
            cur += customers[i];
            if (i - j >= X) {
                cur -= customers[j++];
            }
            max = Math.max(max, cur);
        }
        return ans + max;
    }
}
