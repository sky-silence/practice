package interview.RateLimiter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 令牌桶限流器.
 *
 * @author chengzeshan
 * @version 1.0, 2021/03/17
 * @since practice 1.0.0
 */
public class TokenLimiter {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // 最后一次发令牌的时间
    public long timeStamp = System.currentTimeMillis();
    // 桶容量
    public int capacity = 10;
    //令牌生成速度10/s
    public int rate = 10;
    //当前令牌数量
    public int tokens;

    public void acquire() {
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            long now = System.currentTimeMillis();
            //当前令牌数
            tokens = Math.min(capacity, (int) (tokens + (now -timeStamp) * rate / 1000));
            //每0。5秒发送随机数量的请求
            int permits= (int) (Math.random() * 9) + 1;
            System.out.println("请求令牌数：" + permits + ", 当前令牌书");
            timeStamp = now;
            if (tokens < permits){
                System.out.println("限流了");
            }else {
                tokens -= permits;
                System.out.println("剩余令牌=" + tokens);
            }

        }, 1000, 500, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        TokenLimiter tokenLimiter = new TokenLimiter();
        tokenLimiter.acquire();
    }
}
