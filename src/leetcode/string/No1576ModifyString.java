package leetcode.string;

/**
 * 1576. 替换所有的问号
 *
 * @author chengzeshan
 * @version 1.0, 2022/01/04
 * @since practice 1.0.0
 */
public class No1576ModifyString {

    public String modifyString(String s) {
        char[] charArray = s.toCharArray();
        String a = "abc";
        char[] replaceArray = a.toCharArray();
        if (s.equals("?")) {
            return "a";
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?') {
                if (i == 0) {
                    for (char c : replaceArray) {
                        if (c != charArray[1]) {
                            charArray[i] = c;
                        }
                    }
                } else if (i == charArray.length - 1) {
                    for (char c : replaceArray) {
                        if (c != charArray[charArray.length - 2]) {
                            charArray[i] = c;
                        }
                    }
                } else {
                    for (char c : replaceArray) {
                        if (c != charArray[i + 1] && c != charArray[i - 1]) {
                            charArray[i] = c;
                        }
                    }
                }
            }
        }
        return new String(charArray);
    }
}
