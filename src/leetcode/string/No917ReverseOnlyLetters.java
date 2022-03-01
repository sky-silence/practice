package leetcode.string;

/**
 * 917.仅仅反转字母.
 *
 * @author chengzeshan
 * @version 1.0, 2022/02/23
 * @since practice 1.0.0
 */
public class No917ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("7_28]"));
    }

    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length-1;
        while (true){
            while (l < r && !Character.isLetter(chars[l])){
                l ++ ;
            }
            while (l < r && !Character.isLetter(chars[r])){
                r -- ;
            }
            if (l >= r){
                break;
            }
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);

    }

}
