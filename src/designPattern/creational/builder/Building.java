package designPattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public class Building {

    private List<String> buildingComponents = new ArrayList<>();

    public void setBasement(String basement) {
        this.buildingComponents.add(basement);
    }

    public void setWall(String wall) {
        this.buildingComponents.add(wall);
    }

    public void setRoof(String roof) {
        this.buildingComponents.add(roof);
    }

    @Override
    public String toString() {
        String buildingStr = "";
        for (int i = buildingComponents.size() - 1; i >= 0; i--) {
            buildingStr += buildingComponents.get(i);
        }
        return buildingStr;
    }
}
