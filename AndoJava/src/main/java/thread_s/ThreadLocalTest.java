package thread_s;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内共享变量的概念与作用  2
 * {@link ThreadScopeShareData}
 * <p>
 * todo 2018-6-22 10:00:32
 */
public class ThreadLocalTest {
    static int data = 0;
    static Map<Thread, Integer> threadParam = new HashMap<>();
    ThreadLocal threadLocal;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    data = ++data;
                    int data = new Random().nextInt(10);
                    System.out.println(Thread.currentThread().getName() +
                            " has input data : " + data);
                    threadParam.put(Thread.currentThread(), data);
                    new ThreadScopeShareData.A().get();
                    new ThreadScopeShareData.B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            int data = threadParam.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName()
                    + " get data : " + data);
        }
    }

    static class B {
        public void get() {
            int data = threadParam.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName()
                    + " get data : " + data);
        }
    }

}
