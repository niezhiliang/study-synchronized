package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午3:23
 */
public class SynchronizedStaticAndNormal8 implements Runnable {

    static SynchronizedStaticAndNormal8 instance = new SynchronizedStaticAndNormal8();

    public void run() {
        try {
            if (Thread.currentThread().getName().equals("Thread-0")) {
                method1();
            } else {
                method2();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void method1() throws InterruptedException {
        System.out.println("我是静态加锁的方法。我叫"+Thread.currentThread().getName());
        Thread.sleep(3000);

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2() throws InterruptedException {
        System.out.println("我是非静态加锁的方法。我叫"+Thread.currentThread().getName());
        Thread.sleep(3000);

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);

        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println("finished");
    }

}
