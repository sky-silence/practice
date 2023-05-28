package designPattern.structural.decorator;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public class Lipstick extends Decorator {

    public Lipstick(Showable showable){
        super(showable);//调用化妆品父类注入
    }


}
