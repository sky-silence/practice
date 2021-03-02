package leetcode.tree;

import java.util.*;

/**
 * 572.另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/25
 * @since MyLeetCode 1.0.0
 */
public class No572IsSubtree {
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

    //深度优先暴力匹配 借鉴100
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }
        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && p.val == q.val;
    }

    //深度优先下的字符串匹配（KMP）
    List<Integer> sOrder = new ArrayList<Integer>();
    List<Integer> tOrder = new ArrayList<Integer>();
    int maxElement, lNull, rNull;

    public boolean isSubtree1(TreeNode s, TreeNode t) {
        maxElement = Integer.MIN_VALUE;
        getMaxElement(s);
        getMaxElement(t);
        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        return kmp();
    }

    public void getMaxElement(TreeNode t) {
        if (t == null) {
            return;
        }
        maxElement = Math.max(maxElement, t.val);
        getMaxElement(t.left);
        getMaxElement(t.right);
    }

    public void getDfsOrder(TreeNode t, List<Integer> tar) {
        if (t == null) {
            return;
        }
        tar.add(t.val);
        if (t.left != null) {
            getDfsOrder(t.left, tar);
        } else {
            tar.add(lNull);
        }
        if (t.right != null) {
            getDfsOrder(t.right, tar);
        } else {
            tar.add(rNull);
        }
    }

    public boolean kmp() {
        int sLen = sOrder.size(), tLen = tOrder.size();
        int[] fail = new int[tOrder.size()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < tLen; ++i) {
            while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (tOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < sLen; ++i) {
            while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (sOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            if (j == tLen - 1) {
                return true;
            }
        }
        return false;
    }

    //方法三：树哈希 （看看得了 ，你是看不明白的）
    //思路和算法
    //
    // 考虑把每个子树都映射成一个唯一的数，如果 tt 对应的数字和 ss 中任意一个子树映射的数字相等，则 tt 是 ss 的某一棵子树。如何映射呢？我们可以定义这样的哈希函数：
    //
    // f_o = v_o + 31 \cdot f_l \cdot p(s_l) + 179 \cdot f_r \cdot p(s_r)
    // f
    // o
    // ​
    //  =v
    // o
    // ​
    //  +31⋅f
    // l
    // ​
    //  ⋅p(s
    // l
    // ​
    //  )+179⋅f
    // r
    // ​
    //  ⋅p(s
    // r
    // ​
    //  )
    //
    // 这里 f_xf
    // x
    // ​
    //   表示节点 xx 的哈希值，s_xs
    // x
    // ​
    //   表示节点 xx 对应的子树大小，v_xv
    // x
    // ​
    //   代表节点 xx 的 val，p(n)p(n) 表示第 nn 个素数，oo 表示当前节点，ll 和 rr 分别表示左右孩子。这个式子的意思是：当前节点 oo 的哈希值等于这个点的 val 加上 3131 倍左子树的哈希值乘以第 s_ls
    // l
    // ​
    //   个素数，再加上 179179 倍右子树的哈希值乘以第 s_rs
    // r
    // ​
    //   个素数。这里的 3131 和 179179 这两个数字只是为了区分左右子树，你可以自己选择你喜欢的权值。
    //
    // 这样做为什么可行呢？ 回到我们的初衷，我们希望把每个子树都映射成一个唯一的数，这样真的能够确保唯一吗？实际上未必。但是我们在这个哈希函数中考虑到每个点的 val、子树哈希值、子树大小以及左右子树的不同权值，所以这些因素共同影响一个点的哈希值，所以出现冲突的几率较小，一般我们可以忽略。当然你也可以设计你自己的哈希函数，只要考虑到这些因素，就可以把冲突的可能性设计得比较小。可是如果还是出现了冲突怎么办呢？ 我们可以设计两个哈希函数 f_1f
    // 1
    // ​
    //   和 f_2f
    // 2
    // ​
    //  ，用这两个哈希函数生成第三个哈希函数，比如 f = f_1 + f_2f=f
    // 1
    // ​
    //  +f
    // 2
    // ​
    //  、f = f_1 \times f_2f=f
    // 1
    // ​
    //  ×f
    // 2
    // ​
    //   等等，这样可以进一步缩小冲突，如果 f_1f
    // 1
    // ​
    //   的冲突概率是 P_1P
    // 1
    // ​
    //  ，f_2f
    // 2
    // ​
    //   的冲突概率是 P_2P
    // 2
    // ​
    //  ，那么 ff 的冲突概率就是 P_1 \times P_2P
    // 1
    // ​
    //  ×P
    // 2
    // ​
    //  ，理论上已经非常小了，这就是「双哈希」。当然，为了减少冲突，你也可以设计「三哈希」、「四哈希」等，可是这样编程的复杂度就会增加。实际上，一般情况下，只要运气不是太差，一个哈希函数就足够了。
    //
    // 我们可以用「埃氏筛法」或者「欧拉筛法」求出前 \arg \pi (\max \{ |s|, |t| \})argπ(max{∣s∣,∣t∣}) 个素数（其中 \pi (x)π(x) 表示 xx 以内素数个数，\arg \pi (x)argπ(x) 为它的反函数，表示有多少以内包含 xx 个素数，这个映射是不唯一的，我们取最小值），然后深度优先搜索计算哈希值，最后比较 ss 的所有子树是否有和 tt 相同的哈希值即可。

    static final int MAX_N = 1005;
    static final int MOD = 1000000007;
    boolean[] vis = new boolean[MAX_N];
    int[] p = new int[MAX_N];
    int tot;
    Map<TreeNode, int[]> hS = new HashMap<TreeNode, int[]>();
    Map<TreeNode, int[]> hT = new HashMap<TreeNode, int[]>();

    public boolean isSubtree3(TreeNode s, TreeNode t) {
        getPrime();
        dfs(s, hS);
        dfs(t, hT);

        int tHash = hT.get(t)[0];
        for (Map.Entry<TreeNode, int[]> entry : hS.entrySet()) {
            if (entry.getValue()[0] == tHash) {
                return true;
            }
        }

        return false;
    }

    public void getPrime() {
        vis[0] = vis[1] = true;
        tot = 0;
        for (int i = 2; i < MAX_N; ++i) {
            if (!vis[i]) {
                p[++tot] = i;
            }
            for (int j = 1; j <= tot && i * p[j] < MAX_N; ++j) {
                vis[i * p[j]] = true;
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
    }

    public void dfs(TreeNode o, Map<TreeNode, int[]> h) {
        h.put(o, new int[]{o.val, 1});
        if (o.left == null && o.right == null) {
            return;
        }
        if (o.left != null) {
            dfs(o.left, h);
            int[] val = h.get(o);
            val[1] += h.get(o.left)[1];
            val[0] = (int) ((val[0] + (31L * h.get(o.left)[0] * p[h.get(o.left)[1]]) % MOD) % MOD);
        }
        if (o.right != null) {
            dfs(o.right, h);
            int[] val = h.get(o);
            val[1] += h.get(o.right)[1];
            val[0] = (int) ((val[0] + (179L * h.get(o.right)[0] * p[h.get(o.right)[1]]) % MOD) % MOD);
        }
    }

}
