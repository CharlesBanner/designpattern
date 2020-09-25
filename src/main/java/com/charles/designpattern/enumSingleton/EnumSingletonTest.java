package com.charles.designpattern.enumSingleton;

/**
 * @author CharlesBanner
 * @classname EnumSingletonTest
 * @description TODO
 * @email ganzib4fun@gmail.com
 * @date 2020/9/26 0026 05 : 24
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        instance.print();
        instance1.print();
        EnumSingleton.INSTANCE.detal();
    }

}
