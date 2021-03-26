package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/16
 * @since practice 1.0.0
 */
public class ReentrantlockTest {

    /*
    问题：实现一个多线程类，并用该线程类实例化3个线程A,B,C；A线程打印字符A,B线程打印字符B，C线程打印字符C；启动这3个线程，要求启动线程的顺序为C线程->B线程->A线程，并且最后输出内容为：
    A
    B
    C
    不能用sleep函数，注意考虑线程安全问题。
    ---------------------------------------------------------------------
    */
    private static Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    public static class threadA extends Thread{

        @Override
        public void run() {
            lock.lock();
            try {
                a.await();
                System.out.println("a");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static class threadB extends Thread{

        @Override
        public void run() {
            lock.lock();
            try {
                b.await();
                System.out.println("b");
                a.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

    public static class threadC extends Thread{

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("c");
                b.signal();
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        new threadA().start();
        new threadB().start();
        new threadC().start();
    }

}
