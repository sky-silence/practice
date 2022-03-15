package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128.最长连续序列
 *给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * @author chengzeshan
 * @version 1.0, 2022/03/14
 * @since practice 1.0.0
 */
public class No128LongestConsecutive {

    //哈希集合
    public int longestConsecutive(int[] nums) {
        // 建立一个存储所有数的哈希表，同时起到去重功能
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        // 遍历去重后的所有数字
        for (int num : set) {
            int cur = num;
            // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]之间是连续的，数字有cur - num + 1个
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }

    //哈希集合
    //这种方法其实也是思路1的变种，用于减少遍历次数
    public int longestConsecutive1(int[] nums) {
        // key表示num，value表示num最远到达的连续右边界
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化每个num的右边界为自己
        for (int num : nums) {
            map.put(num, num);
        }

        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int right = map.get(num);
                // 遍历得到最远的右边界
                while (map.containsKey(right + 1)) {
                    right = map.get(right + 1);
                }
                // 更新右边界
                map.put(num, right);
                // 更新答案
                ans = Math.max(ans, right - num + 1);
            }

        }
        return ans;
    }
    //解题思路3：哈希表记录连续区间长度（动态规划）
    // 这是一种非常巧妙的做法，与思路2相同的一点是也利用了Map减小遍历次数。但很重要的一点不同是其value表示的是num所在的连续区间长度。举个例子，当Map的key为5，value为3时，这就表明当前有一个包含5且长度为3的连续区间，当然有多种可能，可以是[3,5],[4,6],[5,7]。
    //
    // 具体做法是：
    //
    // 遍历nums数组中的所有数字num
    // 当num是第一次出现时：
    // （1）分别获取到左相邻数字num-1的连续区间长度left和右相邻数字num+1的连续区间长度right；
    // （2）计算得到当前的区间长度为curLen=left+right+1curLen=left+right+1；
    // （3）更新最长区间长度ans以及左右边界的区间长度。
    // 如果不理解这样做的原因，可以先看一遍代码，再看我的后续解释。
    // 在代码中的left和right能够分别代表num-1的左连续区间的长度和num+1的右连续区间长度，那么为什么map中的value能够时而表示左区间的长度，时而表示右区间的长度呢？
    //
    // 关键在于判断条件上：if (!map.containsKey(num))，这行代码表示num之前并未出现过。那么对于key=num-1来说，它的value表示的区间就只能是[num-value,num-1]，num-1只能是该区间的左边界值，而其它可能的连续区间都会包含num，不符合上述条件；同理，对于key=num+1来说，它的value表示的区间就只能是[num+1,num+value]，num+1只能是该区间的右边界值。
    //
    // 当num已经出现了，这两个区间就可以被联通表示为[num-value1,num+value2]，当前连续区间的左右边界会发生变化，变为num-value1和num+value2，因此我们需要更新这两个边界点对应的区间长度。
    public int longestConsecutive2(int[] nums) {
        // key表示num，value表示num所在连续区间的长度
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // 当map中不包含num，也就是num第一次出现
            if (!map.containsKey(num)) {
                // left为num-1所在连续区间的长度，更进一步理解为：左连续区间的长度
                int left = map.getOrDefault(num - 1, 0);
                // right为num+1所在连续区间的长度，更进一步理解为：右连续区间的长度
                int right = map.getOrDefault(num + 1, 0);
                // 当前连续区间的总长度
                int curLen = left + right + 1;
                ans = Math.max(ans, curLen);
                // 将num加入map中，表示已经遍历过该值。其对应的value可以为任意值。
                map.put(num, -1);
                // 更新当前连续区间左边界和右边界对应的区间长度
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return ans;
    }


}
