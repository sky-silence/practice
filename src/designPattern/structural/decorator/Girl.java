package designPattern.structural.decorator;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public class Girl implements Showable {

    @Override
    public void show() {
        System.out.println("女孩的素颜");
    }

    public static void main(String[] args) {
        Showable madeupGirl = new Lipstick(new FoundationMakeUp(new Girl()));
        madeupGirl.show();
    }
}
