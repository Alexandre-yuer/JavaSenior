package com.alexandre.exer;
public class TriAngleTest {
    public static void main(String[] args) {

        TriAngle t1 = new TriAngle();
        t1.setBase(2.0);
        t1.setHeight(2.4);

        TriAngle t2 = new TriAngle(3.0,4.0);

        System.out.println("base: " + t1.getBase() + ",height: " + t1.getHeight());
        System.out.println("base: " + t2.getBase() + ",height: " + t2.getHeight());

    }
}
