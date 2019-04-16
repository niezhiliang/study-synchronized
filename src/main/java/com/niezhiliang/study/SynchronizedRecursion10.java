package com.niezhiliang.study;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/4/16 下午4:06
 *
 * 可重入粒度测试：递归调用本方法
 */
public class SynchronizedRecursion10 {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion10 synchronizedRecursion10 = new SynchronizedRecursion10();
        synchronizedRecursion10.method1();
    }

    private void method1() {

        System.out.println("这是method1,a = "+a);
        if (a == 0) {
            a++;
            method1();
        }

    }
}
