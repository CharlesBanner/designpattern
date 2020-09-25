package com.charles.designpattern.innerClassSingleton;

/**
 * @author CharlesBanner
 * @classname InnerClassSingletonTest
 * @description 静态内部类单例模式
 * @email ganzib4fun@gmail.com
 * @date 2020/9/26 0026 05 : 05
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
    }

}
class InnerClassSingleton{

    private static class InnerClassHolder{
        private static final InnerClassSingleton INNERCLASSSINGLETON = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.INNERCLASSSINGLETON;
    }
}