package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * @author: chengzeshan
 * @date: 2019-06-11 12:04
 */
public class No018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1 ; j++){
                int l = j + 1, r = nums.length - 1;
                while (l < r){
                    //越界判断
                    if (nums[l] < 0 && nums[i] + nums[j] < Integer.MIN_VALUE - nums[l]) continue;
                    if (nums[i] > 0 && nums[i] + nums[j] > Integer.MAX_VALUE - nums[l]) break;
                    if (nums[i] + nums[j] > - nums[l] - nums[r] + target){
                        while (l < r && nums[r] == nums[r - 1]) r --;
                        r --;
                    }else if(nums[i] + nums[j] < - nums[l] - nums[r] + target){
                        while (l < r && nums[l] == nums[l + 1]) l ++;
                        System.out.println(l);
                        l ++;
                    }else {
                        System.out.println("count:"+ i + " " + j + " " + l + " " + r);
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[l] + " " + nums[r]);
                        if (i > 0){
                            if (nums[i] != nums[i-1]){
                                List<Integer> targetList = new ArrayList<>();
                                targetList.add(nums[i]);
                                targetList.add(nums[j]);
                                targetList.add(nums[l]);
                                targetList.add(nums[r]);
                                resultList.add(targetList);
                            }
                        }else {
                            List<Integer> targetList = new ArrayList<>();
                            targetList.add(nums[i]);
                            targetList.add(nums[j]);
                            targetList.add(nums[l]);
                            targetList.add(nums[r]);
                            resultList.add(targetList);
                        }

                        while (l < r && nums[r] == nums[r - 1]) r --;
                        while (l < r && nums[l] == nums[l + 1]) l ++;
                        l ++;
                        r --;
                    }

                }
                while (j < nums.length-1 && nums[j] == nums[j+1] ) j++;
            }
        }

        return resultList;
    }
}
