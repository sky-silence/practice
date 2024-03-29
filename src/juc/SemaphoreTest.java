package juc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量示例.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/16
 * @since practice 1.0.0
 */
public class SemaphoreTest {

    //比如，现在有 20 辆车要通过这个地段， 警察叔叔规定同一时间，最多只能通过 5 辆车，其他车辆只能等待。只有拿到许可的车辆可通过，
    // 等车辆通过之后，再归还许可，然后把它发给等待的车辆，获得许可的车辆再通行，依次类推。
    private static int count = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(count);

        //指定最多只能有5个线程同时执行
        Semaphore semaphore = new Semaphore(5);

        Random random = new Random();
        for (int i = 0; i < count ; i ++){
            final int no = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        System.out.println(no + "号车可通行");
                        //模拟通行耗时
                        Thread.sleep(random.nextInt(2000));
                        //释放许可
                        semaphore.release();

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });

        }
        executorService.shutdown();
    }
}
