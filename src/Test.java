import java.util.ArrayList;
import java.util.List;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/01
 * @since practice 1.0.0
 */
public class Test {

    private void test() {
    }

    public static int binarySearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int middle = 0;

        if (target < nums[low]) {
            return nums[low];
        }
        if (target > nums[high]) {
            return nums[high];
        }
        if (low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] > target) {
                if (middle > 0 && nums[middle - 1] < target) {
                    return (Math.abs(target - nums[middle]) - Math.abs(target - nums[middle - 1])) < 0 ? middle : middle - 1;
                }
                high = middle - 1;
            } else if (nums[middle] < target) {
                if (middle < nums.length - 1 && nums[middle + 1] > target) {
                    return (Math.abs(target - nums[middle]) - Math.abs(target - nums[middle + 1])) < 0 ? middle : middle + 1;
                }
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        List<String> b = new ArrayList();
        b.add("5");
        b.add("6");
        b.add("3");
        b.add("4");
        // a.removeAll(b);
        // a.addAll(b);
        // System.out.println(a);
        System.out.println(mergeAlias(a,b));
    }
    public static List<String> mergeAlias(List<String> a, List<String> b){
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }
        a.removeAll(b);
        a.addAll(b);
        return a;
    }

}
