package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午3:47
 *
 *  方法抛异常后，会释放锁 展示不抛出异常前和抛出异常后的
 *  对比：一旦抛出异常 第二个线程会立刻进入同步方法 意味着释放了锁
 */
public class SynchronizedException9 implements Runnable {

    static SynchronizedException9 instance = new SynchronizedException9();

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

    public synchronized  void method1() throws InterruptedException {
        System.out.println("我是加锁的方法。我叫"+Thread.currentThread().getName());
        Thread.sleep(3000);

        throw new RuntimeException();

        //System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2() throws InterruptedException {
        System.out.println("我是非加锁的方法。我叫"+Thread.currentThread().getName());
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
