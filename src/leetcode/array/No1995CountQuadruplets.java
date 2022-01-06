package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2021/12/29
 * @since practice 1.0.0
 */
public class No1995CountQuadruplets {
    public static int countQuadruplets(int[] nums) {
        int res = 0;
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int c = len - 1; c >= 2; c--){
            map.put(nums[c],map.getOrDefault(nums[c],0) + 1);
            for (int a=0; a<c ; a ++){
                for (int b = a + 1; b<c ; b++){
                    res += map.getOrDefault(nums[a]+nums[b] +nums[c],0);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,5};
        System.out.println(countQuadruplets(nums));
    }
}
