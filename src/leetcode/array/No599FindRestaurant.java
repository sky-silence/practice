package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 599.两个列表的最小索引总和.
 *
 * @author chengzeshan
 * @version 1.0, 2022/03/14
 * @since practice 1.0.0
 */
public class No599FindRestaurant {

    //["Shogun","Tapioca Express","Burger King","KFC"]
    // ["KFC","Shogun","Burger King"]

    public static void main(String[] args) {
        String[] str1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] str2 = {"KFC","Shogun","Burger King"};

        System.out.println(findRestaurant(str1,str2)[0]);
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0 ; i < list1.length; i++){
            map.put(list1[i],i);
        }
        Integer min=  Integer.MAX_VALUE;
        Map<Integer, List<String>> ansMap = new HashMap<>();
        for (int i = 0 ; i < list2.length; i++){
            if (map.get(list2[i])!= null){
                if (min>map.get(list2[i])+i){
                    min = Math.min(min,map.get(list2[i])+i);
                    List<String> list = new ArrayList<>();
                    list.add(list2[i]);
                    ansMap.put(min,list);
                }else if(min==map.get(list2[i])+i){
                    List<String> list = ansMap.get(min);
                    list.add(list2[i]);
                    ansMap.put(min,list);
                }
            }
        }
        List<String> list = ansMap.get(min);
        String[] ans = list.toArray(new String[list.size()]);
        return ans;
    }

    //法2，一行代码。stream流 骚啊！！！
    public String[] findRestaurant1(String[] list1, String[] list2) {
        return IntStream.range(0, list1.length + list2.length) // 产生0-(n1 + n2 - 1)的int流
                .boxed() // mapToObj(Integer::valueOf) 转为Integer
                // 对相同的String进行groupby，生成map<String, List<Integer>>
                .collect(Collectors.groupingBy(i -> i < list1.length ? list1[i] : list2[i - list1.length]))
                // List<Map.Entry>
                .entrySet()
                // 重新转为流Map.Entry<String, List<Integer>>
                .stream()
                // filter去掉单个情况
                .filter(i -> i.getValue().size() == 2)
                // 再进行groupby，生成TreeMap<Integer, List<String>>
                .collect(Collectors.groupingBy(i -> i.getValue().get(0) + i.getValue().get(1), TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                // 输出第一个
                .firstEntry()
                .getValue()
                .toArray(new String[0]);
    }


}
