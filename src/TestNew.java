/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2023/02/10
 * @since practice 1.0.0
 */
public class TestNew {


    public static void main(String[] args) {
        System.out.println(getTwoLength("abbcbbbc",0,2));
    }
    private static boolean getTwoLength(String str, int s, int e) {
        if(e > str.length()){
            return true;
        }
        if (!str.substring(e).contains(str.substring(s, e))) {
            s = s + 1;
            e = e + 1;
            return getTwoLength(str, s, e);
        } else {
            return false;
        }
    }

}
