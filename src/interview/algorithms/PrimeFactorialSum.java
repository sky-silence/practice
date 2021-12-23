package interview.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 质数阶乘和.
 *
 * @author chengzeshan
 * @version 1.0, 2021/04/05
 * @since practice 1.0.0
 */
public class PrimeFactorialSum {

    public static List<Integer> getPrime(int n){
        int[] isPrime = new int[n+1];
        Arrays.fill(isPrime,1);
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i ++){
            if (isPrime[i] == 1){
                primeList.add(i);
            }
            if (i * i < n){
                for (int j = i * i; j < n ; j += i){
                    isPrime[j] = 0;
                }
            }
        }
        return primeList;
    }

    public static long getFactorial(int n){
        long sum = 1;
        for (int i = 1;i <= n; i ++){
            sum *= i;
        }
        return sum;
    }

    public static long getPrimeFactorialSum(int n){
        long ans = 0;
        List<Integer> primeList = getPrime(n);
        for (Integer prime : primeList) {
            ans += getFactorial(prime);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeFactorialSum(5));
    }

}
