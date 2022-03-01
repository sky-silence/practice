package leetcode.array;

import java.util.Arrays;

/**
 * The xxx class for xxx.
 *
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 *
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 *
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 *
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/where-will-the-ball-fall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chengzeshan
 * @version 1.0, 2022/02/24
 * @since practice 1.0.0
 */
public class No1706FindBall {

    public static void main(String[] args) {
        String a = "sz";
        System.out.println(a.equals("sz|sh"));
    }
    public static int[] findBall(int[][] grid) {
        int len = grid[0].length;
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        for (int j = 0 ; j < len ; j ++){

        }
return ans;
    }

}
