package leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: chengzeshan
 * @date: 2019-06-10 16:31
 */
public class No016ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int dir = Math.abs(sum - target);
        for (int i = 0 ; i < nums.length - 2; i ++){
            int start = i + 1 ;
            int end = nums.length -1 ;
            while (start < end){
                int temp = nums[i] + nums[start] + nums[end];
                System.out.println("nums:"+nums[i]+" "+nums[start]+" "+nums[end]);
                System.out.println("index:"+i+" "+start+" "+end);
                if (temp - target < 0){
                    if (Math.abs(temp-target) < dir){
                        dir = Math.abs(temp-target);
                        sum = temp;
                    }
                    start++;
                }else if (temp - target > 0){
                    if (Math.abs(temp-target) < dir){
                        dir = Math.abs(temp-target);
                        sum = temp;
                    }
                    end --;
                }else if (temp - target == 0){
                    return target;
                }

            }

        }

        return sum;
    }
}
