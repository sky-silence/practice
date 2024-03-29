package juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 辅助同步器.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/16
 * @since practice 1.0.0
 */
public class CountDownLatchTest {

    //当一个线程调用await方法时，就会阻塞当前线程。每当有线程调用一次 countDown 方法时，计数就会减 1。
    // 当 count 的值等于 0 的时候，被阻塞的线程才会继续运行。
    //
    // 现在设想一个场景，公司项目，线上出现了一个紧急 bug，被客户投诉，领导焦急的过来，想找人迅速的解决这个 bug 。
    //
    // 那么，一个人解决肯定速度慢啊，于是叫来张三和李四，一起分工解决。
    // 终于，当他们两个都做完了自己所需要做的任务之后，领导才可以答复客户，客户也就消气了（没办法啊，客户是上帝嘛）。
    //
    // 于是，我们可以设计一个 Worker 类来模拟单个人修复 bug 的过程，主线程就是领导，一直等待所有 Worker 任务执行结束，主线程才可以继续往下走。
    static SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(2);

        Worker w1 = new Worker("张三", 2000, latch);
        Worker w2 = new Worker("李四", 3000, latch);
        w1.start();
        w2.start();

        long startTime = System.currentTimeMillis();
        latch.await();
        System.out.println("bug全部解决，领导可以给客户交差了，任务总耗时："+ (System.currentTimeMillis() - startTime));
    }

    static class Worker extends Thread{
        String name;
        int workTime;
        CountDownLatch countDownLatch;

        public Worker(String name, int workTime, CountDownLatch latch){
            this.name = name;
            this.workTime = workTime;
            this.countDownLatch = latch;
        }

        @Override
        public void run() {
            System.out.println(name+"开始修复bug，当前时间："+sdf.format(new Date()));
            try {
                //模拟工作耗时
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"结束修复bug，当前时间："+sdf.format(new Date()));
            countDownLatch.countDown();
        }
    }
}
