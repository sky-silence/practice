package leetcode.mutiThread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个不同的线程将会共用一个 FooBar 实例：
 *
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/02
 * @since practice 1.0.0
 */
public class No1115AlternatePrint {

    //信号量，控制顺序，最简单
    class FooBar1 {
        private int n;

        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                foo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                bar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo.release();
            }
        }
    }
    //synchronized + 标识位 + 唤醒
    class FooBar2 {
        private int n;
        // 标志位，控制执行顺序，true执行printFoo，false执行printBar
        private volatile  boolean type = true;
        private final  Object foo = new Object(); // 锁标志
        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (foo) {
                    while (!type){
                        foo.wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    type = false;
                    foo.notifyAll();
                }


            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (foo){
                    while (type){
                        foo.wait();
                    }
                    printBar.run();
                    type = true;
                    foo.notifyAll();
                }
            }
        }
    }

    //reenTrantLock + condition
    class FooBar3 {
        private int n;

        public FooBar3(int n) {
            this.n = n;
        }

        Lock lock = new ReentrantLock(true);
        private final Condition foo = lock.newCondition();
        volatile boolean flag = true;

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (!flag){
                        foo.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = false;
                    foo.signal();
                }finally {
                    lock.unlock();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                lock.lock();
                try {
                    while (flag){
                        foo.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printBar.run();
                    flag = true;
                    foo.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class FooBar4 {
        private int n;
        private BlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);
        private BlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);


        public FooBar4(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                foo.put(i);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.put(i);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                bar.take();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo.take();
            }
        }
    }

}
