package leetcode.stack;

import java.util.Deque;

/**
 * 1614. 括号的最大嵌套深度
 * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 *
 * @author chengzeshan
 * @version 1.0, 2022/01/07
 * @since practice 1.0.0
 */
public class No1614MaxDepth {

    public int maxDepth(String s) {
        char[] c= s.toCharArray();
        if (s.length()<=1){
            return 0;
        }
        int ans = 0;
        int count = 0;
        for (int i = 0 ; i < c.length ; i ++){
            if (c[i] =='('){
                count ++;
                ans = Math.max(ans,count);
            }
            if (c[i] ==')'){
                count --;
            }
        }
        return ans;
    }
}
