package leetcode.dynamicPlanning;

/**
 * @description:动态规划练习
 * @author: chengzeshan
 * @date: 2019-09-26 10:12
 */
public class DPPractice {

    //weight:物品重量 n:物品个数 w:背包可承受重量
    public int knapsack(int[] weight,int n , int w ){
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;//第一行特殊处理
        if (weight[0]<=w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++){//dp状态转移
            for (int j = 0; j < w; j++){//不把第i个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j + weight[i] <= w; j++  ){
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        for (int i = w; i >= 0 ; i--){
            if (states[n-1][i] == true) return i;
        }

        return 0;
    }


}
