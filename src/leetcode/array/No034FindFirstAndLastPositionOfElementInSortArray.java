package leetcode.array;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * @author chengzeshan
 * @version 1.0, 2021/04/20
 * @since practice 1.0.0
 */
public class No034FindFirstAndLastPositionOfElementInSortArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int high = nums.length -1;
        int low = 0;
        int middle = 0;
        if (nums.length <= 0 || target < nums[low] || target > nums[high] || high < low){
            return ans;
        }
        int start = 0, end = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] > target) {

                high = middle - 1;
            } else if (nums[middle] < target) {

                low = middle + 1;
            } else {
                start = middle;
                end = middle;
                while ((start >= 0 && nums[start] == target) || (end <= nums.length -1 && nums[end] == target)){
                    if (start >= 0 && nums[start] == target){
                        ans[0] = start;
                        start --;
                    }
                    if (end <= nums.length -1 && nums[end] == target){
                        ans[1] = end;
                        end ++;
                    }
                }
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] q = {1};
        int[] ans =searchRange(q,1);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
