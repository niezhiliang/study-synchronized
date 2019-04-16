package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午3:12
 *
 *  同时访问同步方法和非同步方法
 */
public class SynchronizedYesAndNo6 implements Runnable {

    static SynchronizedYesAndNo6 instance = new SynchronizedYesAndNo6();


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

    public synchronized void method1() throws InterruptedException {
        System.out.println("我是加锁的方法。我叫"+Thread.currentThread().getName());
        Thread.sleep(3000);

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public void method2() throws InterruptedException {
        System.out.println("我是没加锁的方法。我叫"+Thread.currentThread().getName());
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
