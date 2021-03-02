package leetcode.dynamicPlanning;

/**
 * dajiajieshe 2
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/07
 * @since LeetCode 1.0.0
 */
public class No213HouseRobberII {

    /*你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

    给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。。*/

    //状态转移方程
    //dp[i]=max(dp[i−2]+nums[i],dp[i−1])

    //边界条件
    //dp[0]=nums[0]  只有一间房屋，则偷窃该房屋
    //dp[1]=max(nums[0],nums[1]) 只有两间房屋，选择其中金额较高的房屋进行偷窃
    //拆环为两个size-1的列表，取最值

    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < nums.length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i + 1], dp2[i - 1]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 1, 1};
        System.out.println(rob(num));
    }
}
