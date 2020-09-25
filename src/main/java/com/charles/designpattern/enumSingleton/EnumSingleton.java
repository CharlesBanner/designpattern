package com.charles.designpattern.enumSingleton;

/**
 * @author CharlesBanner
 * @classname EnumSingleton
 * @description TODO
 * @email ganzib4fun@gmail.com
 * @date 2020/9/26 0026 05 : 24
 */
public enum  EnumSingleton {

    INSTANCE{
        @Override
        public void detal() {
            System.out.println("this a test");
        }
    };
    public void print(){
        System.out.println(this.hashCode());
    }

    public abstract void detal();
}
