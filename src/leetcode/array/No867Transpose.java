package leetcode.array;

/**
 * 867.转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/25
 * @since MyLeetCode 1.0.0
 */
public class No867Transpose {

    public int[][] transpose(int[][] matrix) {

        int x = matrix.length;
        int y = matrix[0].length;

        int[][] ans = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
