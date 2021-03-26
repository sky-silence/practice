package leetcode.string;

import java.util.*;

/**
 * 179.最大数
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/24
 * @since practice 1.0.0
 */
public class No179LargestNumber {

    //自定义比较算法
    private class LargestNumberComparator implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i ++){
            numStr[i] = String.valueOf(nums[i]);
        }
        //按自定义规则排序
        Arrays.sort(numStr,new LargestNumberComparator());
        //特殊情况
        if(numStr[0].equals("0")){
            return "0";
        }
        //按排序结果拼接答案
        String ans = new String();
        for (String s : numStr) {
            ans += s;
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
