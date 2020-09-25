package com.charles.designpattern.lazysingleton;

import org.jetbrains.annotations.Contract;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CharlesBanner
 * @classname LazySingletonTest
 * @description 懒汉模式
 * @email ganzib4fun@gmail.com
 * @date 2020/9/22 0022 23 : 47
 */
public class LazySingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            LazySingleton instance1 = LazySingleton.getInstance();
            System.out.println(instance == instance1);
        }).start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            LazySingleton instance1 = LazySingleton.getInstance();
            System.out.println(instance == instance1);
        }).start();

        /*反射测试*/
        Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor();
        LazySingleton lazySingleton = declaredConstructor.newInstance();
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(lazySingleton == instance);
    }

}

class LazySingleton {
    private static LazySingleton instance;
    private static final Lock LOCK = new ReentrantLock();

    /**
     * @param
     * @return
     * @Description 无参构造
     * @date 2020/9/22 0022 下午 11:49
     * @author CharlesBanner
     */
    private LazySingleton() {
        if (instance != null){
            throw new RuntimeException("单例模式不允许多个实例");
        }
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            LOCK.lock();
            try {
                instance = new LazySingleton();
                //字节码层面
                //JIT . CPU 指令重排
                //1.分配空间
                //2.初始化
                //3.引用赋值
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }

        }
        return instance;
    }
}
