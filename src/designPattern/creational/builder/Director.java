package designPattern.creational.builder;

/**
 * The xxx class for xxx.
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Building direct() {
        System.out.println("=====工程项目启动=====");
        // 第一步，打好地基；
        builder.buildBasement();
        // 第二步，建造框架、墙体；
        builder.buildWall();
        // 第三步，封顶；
        builder.buildRoof();
        System.out.println("=====工程项目竣工=====");
        return builder.getBuilding();
    }

    public static void main(String[] args) {
        Builder builder = new HouseBuilder();
        Director director = new Director(builder);
        System.out.println(director.direct());
        director.setBuilder(new ApartmentBuilder(10));
        System.out.println(director.direct());
    }
}
