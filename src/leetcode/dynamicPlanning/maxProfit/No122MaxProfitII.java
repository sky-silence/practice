package leetcode.dynamicPlanning.maxProfit;

/**
 * 122.买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author chengzeshan
 * @version 1.0, 2021/03/03
 * @since practice 1.0.0
 */
public class No122MaxProfitII {

    //一次循环
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0;i<prices.length-1;i++){
            if (prices[i]< prices[i+1]){
                profit += prices[i+1] -prices[i];
            }
        }
        return profit;
    }

    //动态规划
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

}
