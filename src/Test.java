import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/01
 * @since practice 1.0.0
 */
public class Test {

    public static void main(String[] args){
        testbc(1,(str,num) -> test(str,num));
        testbf(1,(typ1,typ2) -> testString(typ1,typ2));
    }

   public static void testbc(Integer type, BiConsumer<String,Integer> consumer){
       if (type.equals(1)){
           consumer.accept("test",111);
       }else {
           System.out.println("未执行");
       }
   }

   public static void test(String str,Integer ints){
       System.out.println(str + "===" + ints);
   }

   public static void testbf(Integer t, BiFunction<String,Integer,String> cusFunction){
       if (t.equals(1)){
           System.out.println(cusFunction.apply("tss",333));
       }else {
           System.out.println("未执行");
       }
   }

   public static String testString(String ts,Integer tt){
       return ts + "$$$" + tt;
   }
}
