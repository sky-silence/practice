package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 239.滑动窗口最大值
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/25
 * @since practice 1.0.0
 */
public class No239MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int count = 1;
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (i < k - 1) {
                max = max > nums[i] ? max : nums[i];
            }
            if (i == k - 1) {
                max = max > nums[i] ? max : nums[i];
                ans[0] = max;
            }
            if (i > k - 1) {
                int poll = queue.poll();
                if (poll == max) {
                    if (nums[i] > max) {
                        max = nums[i];
                    } else {
                        Queue<Integer> tmpQueue = new LinkedList<>(queue);
                        max = getMax(tmpQueue);
                    }
                } else {
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }
                ans[count] = max;
                count++;
            }
        }
        return ans;
    }

    public static int getMax(Queue<Integer> queue) {
        int max = Integer.MIN_VALUE;
        while (queue.size() != 0) {
            int tmp = queue.poll();
            max = max > tmp ? max : tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ans = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.asList(ans));
    }
    //理解错了
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     Queue<Integer> ansQueue = new LinkedList<>();
    //     int[] ans = new int[k];
    //     int count = 0;
    //     int max = Integer.MIN_VALUE;
    //     int tmp = 0;
    //     for (int i = 0 ; i < nums.length; i++ ){
    //         queue.offer(nums[i]);
    //         tmp += nums[i];
    //         if (i >= k){
    //             int pre = queue.poll();
    //             tmp -= pre;
    //         }
    //         if (tmp > max){
    //             max = tmp;
    //             ansQueue = new LinkedList<>();
    //             ansQueue.addAll(queue);
    //         }
    //     }
    //     for (int i = 0 ; i < k; i++){
    //         if (ansQueue != null){
    //             ans[i] = ansQueue.poll();
    //         }
    //     }
    //     return ans;
    // }
}
