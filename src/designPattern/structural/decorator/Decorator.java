package designPattern.structural.decorator;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public abstract class Decorator implements Showable {

    protected Showable showable;

    public Decorator(Showable showable) {
        this.showable = showable;
    }

    @Override
    public void show() {

        System.out.print("涂口红(");
        showable.show();
        System.out.print(")");
    }
}
