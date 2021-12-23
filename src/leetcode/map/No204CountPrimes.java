package leetcode.map;

import java.util.Arrays;

/**
 * 204.计数质数
 *
 * @author chengzeshan
 * @version 1.0, 2021/04/08
 * @since practice 1.0.0
 */
public class No204CountPrimes {

    public int countPrimes(int n) {
        int[] isPrime = new int[n+1];
        Arrays.fill(isPrime,1);
        int ans = 0;
        for (int i = 2; i <= n; i ++){
            if (isPrime[i] == 1){
                ans ++;
            }
            if (i * i < n){
                for (int j = i * i; j < n ; j += i){
                    isPrime[j] = 0;
                }
            }
        }
        return ans;
    }
}
