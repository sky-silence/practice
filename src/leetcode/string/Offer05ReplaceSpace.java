package leetcode.string;

/**
 * 剑指offer 05.替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @author chengzeshan
 * @version 1.0, 2021/02/19
 * @since MyLeetCode 1.0.0
 */
public class Offer05ReplaceSpace {

    public String replaceSpace(String s) {
        char[] c = s.toCharArray();
        char[] ans = new char[c.length * 3];
        int x = 0;
        for (int i = 0; i< c.length ;i ++){
            if (c[i] == ' '){
                ans[x++] = '%';
                ans[x++] = '2';
                ans[x++] = '0';
            }else {
                ans[x++] = c[i];
            }
        }
        return new String(ans,0,x);
    }

    public static void main(String[] args) {

    }
}
