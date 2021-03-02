package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 257.二叉树的所有路径
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/25
 * @since MyLeetCode 1.0.0
 */
public class No257BinaryTreePaths {

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        searchPath(root,"",paths);
        return paths;
    }

    public void searchPath(TreeNode root, String path, List<String> paths){
        if (root != null){
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null){
                paths.add(pathSB.toString());
            }else {
                pathSB.append("->");
                searchPath(root.left,pathSB.toString(),paths);
                searchPath(root.right,pathSB.toString(),paths);
            }
        }
    }

    //广度优先搜索
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }



}
