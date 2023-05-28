package juc;

import java.util.concurrent.*;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2023/02/10
 * @since practice 1.0.0
 */
public class TestAnyong {
    static int coreSizer = Runtime.getRuntime().availableProcessors();
    static TimeUnit unit = TimeUnit.MINUTES;

    static BlockingQueue workQueue = new LinkedBlockingQueue<>();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSizer,coreSizer*2,1,unit,workQueue);

    public static String test1(){
        try {
            Thread.sleep(2000);
            System.out.println("test1 运行");
            return "test1";
        }catch (Exception e){
            System.out.println("test1程序异常");
        }
        return null;
    }

    public static String test2(){
        try {
            Thread.sleep(1000);
            System.out.println("test2运行");
            return "test2";
        }catch (Exception e){
            System.out.println("test2程序异常");
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        Long start = System.currentTimeMillis();
        CompletableFuture<String> res1 = CompletableFuture.supplyAsync(() -> test1(),executor);
        CompletableFuture<String> res2 = CompletableFuture.supplyAsync(() -> test2(),executor);
        System.out.println(res1.get());
        System.out.println(res2.get());
        System.out.println("执行时间："+(System.currentTimeMillis()-start)/1000 + " seconds");
        executor.shutdown();

    }

}
