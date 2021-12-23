package juc;

/**
 * 2个线程交替打印大小写英文字母
 *
 * @author chengzeshan
 * @version 1.0, 2021/04/05
 * @since practice 1.0.0
 */
public class TakeTurnsPrint {
    private static volatile int flag = 0;
    private static Object o = new Object();

    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        char[] result = new char[52];
        Thread uppercase = new Thread(()->
        {
            long uppercaseStart = System.currentTimeMillis();
            for (int i = 0; i < 26;i++){
                synchronized (o){
                    if (flag == 1){
                        result[i * 2] = (char)('a' + i);
                        flag = 0;
                        o.notify();
                    }else {
                        try {
                            o.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            long upperCost = System.currentTimeMillis() - uppercaseStart;
            System.out.println("uppercase cost "+ upperCost);
        });

        Thread lowercase = new Thread(()->
        {
            long lowercaseStart = System.currentTimeMillis();
            for (int i = 0; i < 26;i++){
                synchronized (o){
                    if (flag == 0){
                        result[i * 2 + 1] = (char)('A' + i);
                        flag = 1;
                        o.notify();
                    }else {
                        try {
                            o.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
            long lowerCost = System.currentTimeMillis() - lowercaseStart;
            System.out.println("lowercase cost "+ lowerCost);
        });

        uppercase.start();
        lowercase.start();
        uppercase.join();
        lowercase.join();
        System.out.println(result);
        System.out.println("total cost " + (System.currentTimeMillis() - start));
    }
}
