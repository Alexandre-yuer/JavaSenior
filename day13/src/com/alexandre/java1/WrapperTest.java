package com.alexandre.java1;
import org.junit.Test;

/*
 *
 * 包装类的使用：
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 *
 * 2.掌握的：基本数据类型、包装类、String三者之间的相互转换
 *
 *
 */

public class WrapperTest {

    //String类型 ---> 基本数据类型、包装类:调用包装类的parseXxx(String s)
    @Test
    public void test4(){
        String str1 = "123";

        //可能会报NumberFormatException
        int num2 = Integer.parseInt(str1);
        System.out.println(num2 + 1);

        String str2 = "true";
        boolean boo = Boolean.parseBoolean(str2);
        System.out.println(str2);

    }

    //基本数据类型、包装类 ---> String类型：调用String重载的valueOf（Xxx xxx）
    @Test
    public void test3(){
        int num1 = 10;
        //方式1：连接运算
        String str1 = num1 + "";

        //方式2：调用String的valueOf（Xxx xxx）
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);

        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);

        System.out.println(str3);
        System.out.println(str3);


    }

    //包装类 ---> 基本数据类型:调用包装类的xxxValue()
    @Test
    public void test2(){
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        //自动拆箱： 包装类 ---> 基本数据类型
//        int num3 = in1;


        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2);
    }

    //基本数据类型 ---> 包装类：调用包装类的构造器
    @Test
    public void test1(){
        int num1 = 10;
//        System.out.println(num1.toString());

        Integer in1 = new Integer(num1);

        //自动装箱：  基本数据类型 ---> 包装类
//        int num2 = 10;
//        Integer in3 = num2;
        System.out.println(in1.toString());

        Integer in2 = new Integer("123");
        System.out.println(in2.toString());

        //报异常
//        Integer in3 = new Integer("123abc");
//        System.out.println(in3.toString());

        Float f1 = new Float(12.3f);
        System.out.println(f1);

    }
}
