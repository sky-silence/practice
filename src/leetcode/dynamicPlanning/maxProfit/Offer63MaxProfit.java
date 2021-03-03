package leetcode.dynamicPlanning.maxProfit;

/**
 * Offer 63.股票的最大利润
 * 121. 买卖股票的最佳时机
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/03
 * @since practice 1.0.0
 */
public class Offer63MaxProfit {

    //1.一次遍历
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    //2.暴力法就不写了
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 有可能不发生交易，因此结果集的初始值设置为 0
        int res = 0;

        // 枚举所有发生一次交易的股价差
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    //动态规划
    //前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len > 2) {
            return 0;
        }
        int[][] dp = new int[len][2];
        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][i] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
