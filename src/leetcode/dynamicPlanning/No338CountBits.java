package leetcode.dynamicPlanning;

/**
 * 338.比特位计数
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/03
 * @since practice 1.0.0
 */
public class No338CountBits {

    //奇偶性判断
    //奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
    //偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。

    public static int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        for (int i = 1; i <= num ; i++){
            if (i % 2 ==1){
                ans[i] = ans[i-1] +1;
            }else {
                ans[i] = ans[i/2];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        countBits(2);
    }
}
