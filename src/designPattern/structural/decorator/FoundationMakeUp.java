package designPattern.structural.decorator;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public class FoundationMakeUp extends Decorator{

    public FoundationMakeUp(Showable showable){
        super(showable);
    }

    @Override
    public void show() {
        System.out.print("打粉底(");
        super.show();
        System.out.print(")");
    }
}
