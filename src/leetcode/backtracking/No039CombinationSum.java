package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 39.组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/04
 * @since practice 1.0.0
 */
public class No039CombinationSum {

    //我们定义递归函数 dfs(target, combine, idx) 表示当前在 candidates 数组的第 idx 位，
    // 还剩 target 要组合，已经组合的列表为 combine。递归的终止条件为 target <= 0 或者 candidates 数组被全部用完。
    // 那么在当前的函数中，每次我们可以选择跳过不用第 idx 个数，即执行 dfs(target, combine, idx + 1)。
    // 也可以选择使用第 idx 个数，即执行 dfs(target - candidates[idx], combine, idx)，
    // 注意到每个数字可以被无限制重复选取，因此搜索的下标仍为 idx。

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,ans,tmp,0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> tmp, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        //跳过当前数
        dfs(candidates, target, ans, tmp, idx + 1);
        //选择当前数
        if (target - candidates[idx] >= 0) {
            tmp.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, tmp, idx);
            tmp.remove(tmp.size() - 1);
        }
    }
}
