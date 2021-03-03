package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/02
 * @since practice 1.0.0
 */
public class JucTest {

    public static void main(String[] args) {

        ExecutorService executorService1  = Executors.newCachedThreadPool();
        ExecutorService executorService2  = Executors.newCachedThreadPool();
        ExecutorService executorService3  = Executors.newCachedThreadPool();
    }

}
