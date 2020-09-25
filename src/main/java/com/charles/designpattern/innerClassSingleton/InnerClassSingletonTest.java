package com.charles.designpattern.innerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author CharlesBanner
 * @classname InnerClassSingletonTest
 * @description 静态内部类单例模式
 * 类加载 初始化阶段就完成了对实例的初始化  本质上就是借助与Jvm类加载机制 保证实例的唯一性。
 * 连接：a验证   b准备(给类的静态成员变量赋默认值) c解析
 * 初始化  :  给类的静态变量赋初值
 * 只有在真正使用对应类时 才会触发初始化
 * (如 当前类时启动类即main函数所在类  直接进行new操作 访问静态属性 访问静态方法 使用反射访问类  初始化一个类的子类)
 * @email ganzib4fun@gmail.com
 * @date 2020/9/26 0026 05 : 05
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*多线程*/
        new Thread(()->{
            InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
            System.out.println(instance1);
        }).start();
        new Thread(()->{
            InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
            System.out.println(instance2);
        }).start();
        /*反射*/
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton == instance);

    }

}
class InnerClassSingleton{

    private static class InnerClassHolder{
        private static final InnerClassSingleton INNERCLASSSINGLETON = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        if (InnerClassHolder.INNERCLASSSINGLETON != null){
            throw new RuntimeException("单例模式不允许多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.INNERCLASSSINGLETON;
    }
}