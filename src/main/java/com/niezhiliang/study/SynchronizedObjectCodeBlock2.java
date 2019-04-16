package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午2:12
 *
 * 对象锁示例1 代码块形式
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 synchronizedObjectCodeBlock2 = new SynchronizedObjectCodeBlock2();

    static Object lock1 = new Object();

    static Object lock2 = new Object();

    public void run() {

        synchronized (lock1) {
            System.out.println("我是lock1，我叫"+Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("我是lock1，"+Thread.currentThread().getName()+"运行完毕");
        }

//        synchronized (lock2) {
//            System.out.println("我是我是lock2，我叫"+Thread.currentThread().getName());
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("我是我是lock2，"+Thread.currentThread().getName()+"运行完毕");
//        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(synchronizedObjectCodeBlock2);

        Thread t2 = new Thread(synchronizedObjectCodeBlock2);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println("finished");
    }
}
