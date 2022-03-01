package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 373. 查找和最小的 K 对数字
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 
 *
 * @author chengzeshan
 * @version 1.0, 2022/01/14
 * @since practice 1.0.0
 */
public class No373KSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int alen = nums1.length;
        int blen = nums2.length;
        int left = 0;
        int right = 0;

        List<List<Integer>> ans = new ArrayList<>();
        while (left < alen && right < blen) {
            List<Integer> list = new ArrayList<>();

            list.add(nums1[left]);
            list.add(nums2[right]);
            ans.add(list);

            if (ans.size() == k) {
                return ans;
            }
            if (left < alen - 1 && right < blen - 1) {
                if (nums1[left + 1] < nums2[right + 1]) {
                    left++;
                } else {
                    right++;
                }
            } else if (left == alen - 1) {
                right++;
            } else if (right == blen - 1) {
                left++;
            }
        }
        return ans;
    }
}
