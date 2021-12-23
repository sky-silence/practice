package juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 记录方法调用次数.（注意线程安全）待优化
 *
 * @author chengzeshan
 * @version 1.0, 2021/04/02
 * @since practice 1.0.0
 */
public class GetCount {

    private volatile static Map<String,Integer> map = new ConcurrentHashMap<>();

    public static int getCount(String userId){
        if (!map.containsKey(userId)){
            map.put(userId,1);
        }else {
            map.put(userId,new AtomicInteger(map.get(userId)).getAndAdd(1));
        }
        return map.get(userId);
    }

}
