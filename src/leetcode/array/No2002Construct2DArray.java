package leetcode.array;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2022/01/01
 * @since practice 1.0.0
 */
public class No2002Construct2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, ans[i / n], 0, n);
        }
        return ans;

    }

    public static void main(String[] args) {

    }

}
