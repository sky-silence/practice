package leetcode.tree;

/**
 * 700.二叉搜索树
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/09
 * @since practice 1.0.0
 */
public class No700SearchBST {

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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val){
            return root;
        }
        return root.val > val ? searchBST(root.left,val) : searchBST(root.right,val);
    }

}
