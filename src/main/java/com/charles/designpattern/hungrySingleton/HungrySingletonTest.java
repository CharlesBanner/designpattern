package com.charles.designpattern.hungrySingleton;

/**
 * @author CharlesBanner
 * @classname HungrySingletonTest
 * @description 饿汉模式
 * 类加载 初始化阶段就完成了对实例的初始化  本质上就是借助与Jvm类加载机制 保证实例的唯一性。
 * 连接：a验证   b准备(给类的静态成员变量赋默认值) c解析
 * 初始化  :  给类的静态变量赋初值
 * 只有在真正使用对应类时 才会触发初始化
 * (如 当前类时启动类即main函数所在类  直接进行new操作 访问静态属性 访问静态方法 使用反射访问类  初始化一个类的子类)
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

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
