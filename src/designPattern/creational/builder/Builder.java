package designPattern.creational.builder;

/**
 * 施工方接口
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public interface Builder {

    public void buildBasement();

    public void buildWall();

    public void buildRoof();

    public Building getBuilding();

}
