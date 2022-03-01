package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2022/01/06
 * @since practice 1.0.0
 */
public class No074SimplifyPath {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }


}
