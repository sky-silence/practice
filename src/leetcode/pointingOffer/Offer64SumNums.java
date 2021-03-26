package leetcode.pointingOffer;

/**
 * 剑指offer64.求1+2+...+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author chengzeshan
 * @version 1.0, 2021/03/05
 * @since practice 1.0.0
 */
public class Offer64SumNums {
    //感觉没啥意义
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
