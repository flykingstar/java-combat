import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dengzhe
 * @date 2022/5/22
 */
public class ThreadTest {
    /**
     * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
     * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
     * 写出你的方法，越多越好，提交到github。
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int a = 10, b = 15, result = 0;
        //第一种
        result = calculate1(a, b);
        //第二种
//        result = calculate2(a, b);
        //第三种
//        result = calculate3(a, b);
        //第四种
//        result = calculate4(a, b);
        System.out.println("运行结果：" + result);
    }

    public static int calculate1(int a, int b) throws InterruptedException, ExecutionException, TimeoutException {
        Future<Integer> submitResult = Executors.newCachedThreadPool().submit(() -> {
            return a + b;
        });
        return submitResult.get(2000, TimeUnit.SECONDS);
    }

    public static int calculate2(int a, int b) throws InterruptedException, ExecutionException, TimeoutException {
        Future<Integer> submitResult = Executors.newFixedThreadPool(1).submit(() -> {
            return a + b;
        });
        return submitResult.get(2000, TimeUnit.SECONDS);
    }


    public static int calculate3(int a, int b) throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask<Integer> task = new FutureTask<>(
                () -> a + b);
        new Thread(task).start();
        return task.get();
    }

    public static int calculate4(int a, int b) throws InterruptedException, ExecutionException, TimeoutException {
        AtomicInteger result = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(
                () -> {
                    result.set(a + b);
                    countDownLatch.countDown();
                }
        );
        thread.start();
        countDownLatch.await();
        return result.get();
    }
}
