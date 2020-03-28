package com.kither.future;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Future<String> submit = executorService.submit(new Echo2());
//        Future<String> submit2 = executorService.submit(new Echo());
//        long currentTimeMillis = System.currentTimeMillis();
//        System.out.println("开始时间-----" + currentTimeMillis);
//        System.out.println(submit.get());
//        System.out.println(submit2.get());
//        long end = System.currentTimeMillis();
//        System.out.println("结束时间-----" + end + " ,时间差：" + (end - currentTimeMillis));
//        executorService.shutdown();

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // 从项目根路径下开始找
        System.out.println(loader.getResource("").getPath());
        System.out.println(loader.getResource("com/kither/future/aaa.txt").getPath());
        // 从类路径下开始找
        System.out.println(FutureDemo.class.getResource("").getPath());
        System.out.println(FutureDemo.class.getResource("/").getPath());
        System.out.println(FutureDemo.class.getResource("aaa.txt").getPath());
    }

    static class Echo implements Callable<String> {
        @Override
        public String call() throws Exception {
            String name = Thread.currentThread().getName();
            System.out.printf("Echo：当前线程开始：名称[%s], 当前时间[%d]\n", name, System.currentTimeMillis());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Echo：当前线程结束：名称[%s], 当前时间[%d]\n", name, System.currentTimeMillis());
            return "Echo：" + name + "执行完成";
        }
    }

    static class Echo2 implements Callable<String> {
        @Override
        public String call() throws Exception {
            String name = Thread.currentThread().getName();
            System.out.printf("Echo2：当前开始线程名称[%s], 当前时间[%d]\n", name, System.currentTimeMillis());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Echo2：当前结束线程名称[%s], 当前时间[%d]\n", name, System.currentTimeMillis());
            return "Echo2：" + name + "执行完成";
        }
    }
}
