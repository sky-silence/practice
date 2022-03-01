package leetcode.greedy;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2022/01/12
 * @since practice 1.0.0
 */
public class No334IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3){
            return false;
        }
        boolean ans = false;
        for (int i =0 ; i < nums.length-2 ; i ++){
            if ((nums[i] < nums[i+1]) && (nums[i+1] < nums[i + 2])){
                return true;
            }
        }

        return ans;
    }
}
