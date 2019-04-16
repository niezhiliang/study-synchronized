package com.niezhiliang.study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午4:49
 *
 * 展示Lock的方法
 */
public class LockExample15 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        lock.tryLock();

        //lock.tryLock(10,TimeUnit.SECONDS);

    }
}
