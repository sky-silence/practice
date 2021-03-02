package leetcode.tree;

/**
 * 226.反转二叉树.
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/24
 * @since MyLeetCode 1.0.0
 */
public class No226InvertTree {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        this.invertTree(root.left);
        this.invertTree(root.right);
        return root;
    }


}
