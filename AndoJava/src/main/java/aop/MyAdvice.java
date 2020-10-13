package aop;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {

    private long beginTime = 0;

    @Override
    public void beforeMethod(Method method) {
        System.out.println("到传智播客来学习啦！");
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void afterMethod(Method method) {
        System.out.println("从传智播客毕业上班啦！");
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " running time of " + (endTime - beginTime));
    }

}