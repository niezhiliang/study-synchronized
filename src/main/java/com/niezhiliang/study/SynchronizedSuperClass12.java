package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午4:12
 *
 * 可重入粒度测试，调用父类的方法
 */
public class SynchronizedSuperClass12 {

    public synchronized void doSomething() {
        System.out.println("我是父类的方法");
    }

}


class TestClass extends SynchronizedSuperClass12 {

    public synchronized void doSomething() {
        System.out.println("我是子类的方法");

        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass s = new TestClass();
        s.doSomething();
    }
}
