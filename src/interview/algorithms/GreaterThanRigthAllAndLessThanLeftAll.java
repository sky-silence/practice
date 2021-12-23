package interview.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * input: 9,8,7,3,4,2,1
 * output: 9,8,7,2,1
 * <p>
 * input: 3,3,1
 * output: 1
 * <p>
 * 找到数组中, 比左边所有数字都小, 比右边所有数字都大的 数字
 *
 * @author chengzeshan
 * @version 1.0, 2021/04/07
 * @since practice 1.0.0
 */
public class GreaterThanRigthAllAndLessThanLeftAll {

    public static List<Integer> greaterThanRigthAllAndLessThanLeftAll(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;

        //2.第一次便利找到满足情况一：当前元素 < 左边所有元素
        // Queue<Integer> leftMin = new LinkedList<>();
        List<Integer> leftMin = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (min > nums[i]) {
                // leftMin.offer(i);
                leftMin.add(i);
            }
            min = Math.min(min, nums[i]);
        }

        //2.第二次便利找到满足情况二：当前元素 > 右边所有元素
        // Queue<Integer> rightMax = new LinkedList<>();
        List<Integer> rightMax = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > max) {
                // rightMax.offer(i);
                rightMax.add(i);
            }
            max = Math.max(max, nums[i]);
        }
        //求并集
        leftMin.retainAll(rightMax);
        return leftMin;
        // while (!leftMin.isEmpty()) {
        //     Integer pop = leftMin.poll();
        //     if (rightMax.contains(pop)) {
        //         ans.add(nums[pop]);
        //     }
        // }

        // return ans;
    }

    public static void main(String[] args) {
        // int[] nums = {3,1,3,1};
        int[] nums = {9, 8, 7, 4, 5, 3, 2, 1};
        System.out.println(greaterThanRigthAllAndLessThanLeftAll(nums));
    }
}
