package leetcode.string;

/**
 * 454.反转字符串II
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/19
 * @since MyLeetCode 1.0.0
 */
public class No541ReverseStringII {


    public static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i += 2 * k) {
            for (int left = i, right = Math.min(i + k - 1, len - 1); left < right; left++, right--) {
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("string", 2));
    }
}
