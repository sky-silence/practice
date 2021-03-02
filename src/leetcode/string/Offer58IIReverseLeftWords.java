package leetcode.string;

/**
 * 剑指offer58II.左旋转字符串
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/19
 * @since MyLeetCode 1.0.0
 */
public class Offer58IIReverseLeftWords {
    //上工具
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        String a = s.substring(0,n);
        String b = s.substring(n,len);
        return b + a;
    }
    //列表遍历拼接
    public String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
    //取余？ 此操作甚骚，没有想到
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
}
