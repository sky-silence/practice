package designPattern.creational.singleton;

/**
 * 双重检验模式
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/01
 * @since practice 1.0.0
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton(){
    }

    public static DoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                    System.out.println("初始化成功");
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckSingleton d = DoubleCheckSingleton.getInstance();
    }

}
