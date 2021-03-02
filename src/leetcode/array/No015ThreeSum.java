package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * @author: chengzeshan
 * @date: 2019-06-06 15:45
 */
public class No015ThreeSum {

    //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length - 1 ; i++){
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                //越界判断
//                System.out.println("count"+i + "" + l + " " + r);
//                System.out.println(nums[i] + " " + nums[l] + " " + nums[r]);
                if (nums[l] < 0 && nums[i] < Integer.MIN_VALUE - nums[l]) continue;
                if (nums[i] > 0 && nums[i] > Integer.MAX_VALUE - nums[l]) break;
                if (nums[i] > - nums[l] - nums[r]){
                    while (l < r && nums[r] == nums[r - 1]) r --;
                    r --;
                }else if(nums[i] < - nums[l] - nums[r]){
                    while (l < r && nums[l] == nums[l + 1]) l ++;
                    System.out.println(l);
                    l ++;
                }else {
                    System.out.println("count"+i + " " + l + " " + r);
                    System.out.println(nums[i] + " " + nums[l] + " " + nums[r]);

                    List<Integer> target = new ArrayList<>();
                    target.add(nums[i]);
                    target.add(nums[l]);
                    target.add(nums[r]);
                    resultList.add(target);
                    while (l < r && nums[r] == nums[r - 1]) r --;
                    while (l < r && nums[l] == nums[l + 1]) l ++;
                    l ++;
                    r --;
                }

            }
            while (i < nums.length-1 && nums[i] == nums[i+1] ) i++;
        }

        return resultList;
    }

    //方法2：特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
    // 对数组进行排序。
    // 遍历排序后数组：
    // 若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
    // 对于重复元素：跳过，避免出现重复解
    // 令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
    // 当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
    // 若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
    // 若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
    //
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
}
