package leetcode.array;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样
 *
 * @author chengzeshan
 * @version 1.0, 2021/12/22
 * @since practice 1.0.0
 */
public class No475FindRadius {

    public static int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int loc = houses[i];
            int dis = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                int heat = heaters[j];
                dis = Math.min(dis,Math.abs(heat - loc));

            }
            count = Math.max(count, dis);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2};
        System.out.println(findRadius(a, b));
    }
}
