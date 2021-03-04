package leetcode.dynamicPlanning;

/**
 * 300.最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/04
 * @since practice 1.0.0
 */
public class No300LengthOfLIS {

    //1.动态规划
    //dp[i] = max(dp[j]) + 1,且 num[j] < num[i], 0 <= j < i
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++){
            dp[i] =1;
            for (int j = 0; j < i; j ++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
