package leetcode.math;

/**
 * 258.各位相加
 *
 * @author chengzeshan
 * @version 1.0, 2022/03/03
 * @since practice 1.0.0
 */
public class No258AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(10));
    }

    public static int addDigits(int num) {
        int ans =num;

        while (ans >= 10){
            ans = 0;
            while(num>0){

                ans += num%10;
                num = num/10;
            }
            num = ans;
        }

        return ans;
    }
}
