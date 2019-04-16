package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 上午11:47
 *
 *  消失的请求数
 */
public class DisappearRequest1 implements Runnable{

    static DisappearRequest1 instance = new DisappearRequest1();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }

    public  void run() {

        synchronized (this) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }

    }
}
