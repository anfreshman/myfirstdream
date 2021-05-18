package 多线程;

import java.util.concurrent.*;

/**
 * @author: 303014439
 * @date: 2021/5/18 22:19
 * @description:饥饿是指一个线程迟迟无法获得资源的情况
 * 我们可以创建一个单例模式的线程池，然后使用线程池submit一个由返回值的线程，在这个线程的call()方法中再使用线程池submit另一个线程
 * 并且在返回值中加入submit.get()，Executor的submit是异步执行的，但Future的get在只有一个线程池的情况下只能同步等待
 * 这样第二个线程等待第一个线程执行完毕再执行，就会陷入饥饿状态
 */
public class 饥饿死锁 {
//    创建单例线程池
    public static ExecutorService single = Executors.newSingleThreadExecutor();

//    创建第二个线程
    public static class AnotherThread implements Callable{
//    重写call方法
    @Override
    public String call() throws Exception {
        System.out.println("in AnotherThread");
        return "success-2";
    }
}

    public static class MyThread implements Callable{

        @Override
        public String call() throws Exception {
            System.out.println("in MyThread");
            Future submit = single.submit(new AnotherThread());
            return "success-1" + submit.get();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
//        执行call方法
        Future submit = single.submit(myThread);
        System.out.println(submit.get());
        single.shutdown();
    }
}
