package leetcode.string;

/**
 * 6. Z 字形变换
 *
 * @author chengzeshan
 * @version 1.0, 2022/03/01
 * @since practice 1.0.0
 */
public class No006Convert {

    public static void main(String[] args) {
        // System.out.println(convert("AB",2));
        System.out.println(convert("PAYPALISHIRING",3));
    }
    public static String convert(String s, int numRows) {

        int len = s.length();
        StringBuffer[] s1 = new StringBuffer[numRows];
        if (numRows == 1){
            return s;
        }
        for (int i = 0, x = 0 , flag = 0; i < len  ; i ++ ){
            if (s1[x] == null){
                s1[x] = new StringBuffer();
            }
            s1[x].append(s.charAt(i));
            if (flag == 0){
                x ++;
                if (x == numRows -1){
                    flag = 1;
                }


            }else {
                x --;
                if (x == 0){
                    flag = 0;
                }
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer stringBuffer : s1) {
            if (stringBuffer != null){
                ans = ans.append(stringBuffer);
            }
        }
        return ans.toString();
    }
}
