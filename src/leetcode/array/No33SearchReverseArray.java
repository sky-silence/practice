package leetcode.array;

/**
 * 33.搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/18
 * @since practice 1.0.0
 */
public class No33SearchReverseArray {

    public static int search(int[] nums, int target) {

        int len = nums.length;
        int ans = -1;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int l = 0, r = len -1 ;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l + " " + r);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 1));
    }
}
