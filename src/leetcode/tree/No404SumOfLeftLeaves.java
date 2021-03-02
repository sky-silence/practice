package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404.左叶子之和
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/25
 * @since MyLeetCode 1.0.0
 */
public class No404SumOfLeftLeaves {

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

    //深度优先搜索
    public int sumOfLeftLeaves(TreeNode root) {

        return root != null ? dfs(root) : 0;
    }

    private int dfs(TreeNode node){
        int ans = 0;
        if (node.left != null){
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)){
            ans += dfs(node.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }

    //广度优先搜索
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }


}
