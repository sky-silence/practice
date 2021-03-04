package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77.组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/26
 * @since MyLeetCode 1.0.0
 */
public class No077Combine {


    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }
    //回溯
    public void dfs(int cur, int end, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (end - cur + 1 + tmp.size() < k) {
            return;
        }
        //记录符合的答案
        if (tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        //1.选择当前位置
        tmp.add(cur);
        dfs(cur + 1, end, k);
        //2.不考虑当前位置
        tmp.remove(tmp.size() - 1);
        dfs(cur + 1, end, k);
    }
}
