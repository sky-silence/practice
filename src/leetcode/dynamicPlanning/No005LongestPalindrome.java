package leetcode.dynamicPlanning;

/**
 * @description:
 * @author: chengzeshan
 * @date: 2019-12-11 15:16
 */
public class No005LongestPalindrome {

    public String longestPalindrome(String s) {
        int longestNum = 1;
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String longestStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];

        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (dp[l + 1][r - 1] || r - l <= 2)) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestNum) {
                        longestNum = r - l + 1;
                        longestStr = s.substring(l, r + 1);
                    }
                }
            }
        }

        return longestStr;
    }
}
