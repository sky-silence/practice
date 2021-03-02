package leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 454.四数相加
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/19
 * @since LeetCode 1.0.0
 */
public class No454FourSumCountII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> countAB = new HashMap<>();
        int ans = 0;
        for (int i : A) {
            for (int j : B) {
                countAB.put((i + j), countAB.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int i : C) {
            for (int j : D) {
                if (countAB.containsKey(-i - j)) {
                    ans += countAB.get(-i - j);
                }
            }
        }
        return ans;
    }
}
