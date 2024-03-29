package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午2:49
 */
public class SynchronizedClassClass5 implements Runnable{

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void method() throws InterruptedException {

        synchronized (SynchronizedClassClass5.class) {
            System.out.println("我是类锁的第二种形式:synchronized(*.class)。我叫"+Thread.currentThread().getName());

            Thread.sleep(3000);

            System.out.println(Thread.currentThread().getName()+"执行完毕");
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(instance1);

        Thread t2 = new Thread(instance2);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }

        System.out.println("finished");
    }


}
