package designPattern.creational.singleton;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/16
 * @since practice 1.0.0
 */
public class Singleton {
    private Singleton(){

    }

    private static class singletonFactory{
        static Singleton singleton = new Singleton();
    }

    public Singleton getInstance(){
        return singletonFactory.singleton;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
