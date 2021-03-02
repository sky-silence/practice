package leetcode.array;

/**
 * 665.非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/08
 * @since LeetCode 1.0.0
 */
public class No665CheckPossibility {

    public static boolean checkPossibility1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                nums[i] = y;
                if (isSorted(nums)) {
                    return true;
                }
                nums[i] = x; // 复原
                nums[i + 1] = x;
                return isSorted(nums);
            }
        }
        return true;
    }

    public static boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
    //上面的代码多次遍历了 \textit{nums}nums 数组，能否只遍历一次呢？
    //
    // 修改 \textit{nums}[i]nums[i] 为 \textit{nums}[i+1]nums[i+1] 后，
    // 还需要保证 \textit{nums}[i-1]\le\textit{nums}[i]nums[i−1]≤nums[i] 仍然成立，
    // 即 \textit{nums}[i-1]\le\textit{nums}[i+1]nums[i−1]≤nums[i+1]，若该不等式不成立则整个数组必然不是非递减的，
    // 则需要修改 \textit{nums}[i+1]nums[i+1] 为 \textit{nums}[i]nums[i]。修改完后，接着判断后续数字的大小关系。
    // 在遍历中统计 \textit{nums}[i]>\textit{nums}[i+1]nums[i]>nums[i+1] 的次数，若超过一次可以直接返回 \text{false}false。

    public boolean checkPossibility2(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,3,2,2};
        System.out.println(checkPossibility1(nums));
    }
}
