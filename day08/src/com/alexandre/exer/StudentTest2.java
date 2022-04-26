package com.alexandre.exer;

public class StudentTest2 {
    public static void main(String[] args) {

        //声明Student类型的数组
        Student1[] stu = new Student1[20];

        //创建20学生对象
        for (int i = 0; i < stu.length; i++) {
            //给数组元素赋值
            stu[i] = new Student1();

            //学生编号
            stu[i].number = i + 1;

            //学生年级[1 6]
            stu[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);

            //学生分数[0 100]
            stu[i].score = (int) (Math.random() * (100 - 0 + 1));
        }

        StudentTest2 test = new StudentTest2();


        //遍历学生数组
        test.print(stu);
        System.out.println("-------------------------------");

        //问题一：打印三年级学生信息
        test.searchState(stu,3);
        System.out.println("-------------------------------");

        //问题二：使用冒泡排序按学生成绩排序，并遍历所有学生的信息
        test.sort(stu);
        //遍历学生数组
        test.print(stu);



    }

    //遍历Student1[]数组的操作
    public void print(Student1[] stu) {
        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i].info());
        }
    }

    //查找Student1数组中指定年级的学生信息
    public void searchState(Student1[] stu, int state){
        for (int i = 0; i < stu.length; i++) {
            if (stu[i].state == state) {
                System.out.println(stu[i].info());
            }
        }
    }

    //给Student1数组排序
    public void sort(Student1[] stu){
        for (int i = 0; i < stu.length; i++) {
            for (int j = 0; j < stu.length - i - 1; j++) {
                if (stu[j].score > stu[j + 1].score) {
                    //如果需要换序，交换的是数组的元素：Student对象！
                    Student1 temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }
}

class Student1 {
    int number;
    int state;
    int score;

    //显示学生信息的方法
    public String info() {
        return "学号：" + number + ",年级：" + state + ",成绩：" + score;
    }


}