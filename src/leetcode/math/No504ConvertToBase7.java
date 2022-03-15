package leetcode.math;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2022/03/07
 * @since practice 1.0.0
 */
public class No504ConvertToBase7 {

    public static void main(String[] args) {
        System.out.println(convertToBase7(-8));
    }

    public static String convertToBase7(int num) {
        if (num == 0){
            return "0";
        }
        boolean flag = true;
        String ans = "";
        if (num < 0){
            num = Math.abs(num);
             flag = false;
        }

        while (num >0) {

            Integer relese = num % 7;
            ans = relese + ans;

            num = num / 7;
        }

        return flag ? ans : "-" + ans;
    }
}
