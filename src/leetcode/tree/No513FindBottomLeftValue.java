package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513.找树左下角的值
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/25
 * @since MyLeetCode 1.0.0
 */
public class No513FindBottomLeftValue {
    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //层序遍历
    //先又后左
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = new TreeNode(-100);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.right != null) {
                // 先把右节点加入 queue
                queue.offer(temp.right);
            }
            if (temp.left != null) {
                // 再把左节点加入 queue
                queue.offer(temp.left);
            }
        }

        return temp.val;
    }

}
