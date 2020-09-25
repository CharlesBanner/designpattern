package com.charles.designpattern.hungrySingleton;

/**
 * @author CharlesBanner
 * @classname HungrySingletonTest
 * @description 饿汉模式
 * @email ganzib4fun@gmail.com
 * @date 2020/9/26 0026 04 : 51
 */
public class HungrySingletonTest {

    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance == instance1);
    }

}
class HungrySingleton {

    private String name;

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
