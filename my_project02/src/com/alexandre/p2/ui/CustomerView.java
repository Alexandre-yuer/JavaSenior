package com.alexandre.p2.ui;

import com.alexandre.p2.bean.Customer;
import com.alexandre.p2.service.CustomerList;
import com.alexandre.p2.util.CMUtility;

/**
 * @ClassName CustomerView
 * @Description: CustomerView为主模块，负责菜单的显示和处理用户操作
 * @Author: alexandre
 * @Date: 2022/4/28 15:20
 */

public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("王涛", '男', 23, "13812312321", "13812312321@qq.com");
        customerList.addCustomer(customer);
    }

    /**
     * @description: 显示《客户信息管理软件》界面的方法
     * @param:
     * @return: void
     */
    public void enterMainMenu() {

        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n---------------------客户信息管理软件---------------------\n");
            System.out.println("                        1.添加客户");
            System.out.println("                        2.修改客户");
            System.out.println("                        3.删除客户");
            System.out.println("                        4.客户列表");
            System.out.println("                        5.退  出\n");
            System.out.println("                    请选择（1-5）：");

            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出（Y/N）:");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }

        }
    }

    /**
     * @description: 添加客户的操作
     * @param:
     * @return: void
     */
    private void addNewCustomer() {
        System.out.println("---------------------------添加客户---------------------------");
        System.out.println("姓名：");
        String name = CMUtility.readString(10);

        System.out.println("性别：");
        char gender = CMUtility.readChar();

        System.out.println("年龄：");
        int age = CMUtility.readInt();

        System.out.println("电话：");
        String phone = CMUtility.readString(13);

        System.out.println("邮箱：");
        String email = CMUtility.readString(30);

        //将上述数据封装到对象中
        Customer cust = new Customer(name, gender, age, phone, email);

        boolean isSuccess = customerList.addCustomer(cust);
        if (isSuccess) {
            System.out.println("---------------------------添加完成---------------------------");
        } else {
            System.out.println("---------------------------客户目录已满，添加失败---------------------------");
        }

    }

    /**
     * @description: 修改客户的操作
     * @param:
     * @return: void
     */
    private void modifyCustomer() {
        System.out.println("---------------------------修改客户---------------------------");
        Customer cust;
        int number;
        for (; ; ) {
            System.out.print("请选择待修改客户编号（-1退出）：");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }
            cust = customerList.getCustomer(number - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else {//找到相应编号的客户
                break;
            }
        }
        //修改客户信息
        System.out.println("姓名（" + cust.getName() + "):");
        String name = CMUtility.readString(10, cust.getName());

        System.out.println("性别（" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());

        System.out.println("年龄（" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());

        System.out.println("电话（" + cust.getPhone() + "):");
        String phone = CMUtility.readString(13, cust.getPhone());

        System.out.println("邮箱（" + cust.getEmail() + "):");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);

        boolean isRepalaced = customerList.replaceCustomer(number - 1, newCust);
        if (isRepalaced) {
            System.out.println("---------------------------修改完成---------------------------");
        } else {
            System.out.println("---------------------------修改失败---------------------------");
        }

    }

    /**
     * @description: 删除客户的操作
     * @param:
     * @return: void
     */
    private void deleteCustomer() {
        System.out.println("---------------------------删除---------------------------");
        int number;
        for (; ; ) {
            System.out.println("请选择待删客户编号（-1退出）");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            Customer customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {//找到相应编号的客户
                break;
            }
        }

        //找到指定的客户
        System.out.println("确认是否删除（Y/N）：");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean deleleSuccess = customerList.deleteCustomer(number - 1);
            if (deleleSuccess) {
                System.out.println("---------------------------删除完成---------------------------");
            } else {
                System.out.println("---------------------------删除失败---------------------------");
            }
        } else {
            return;
        }

    }

    /**
     * @description: 显示客户列表的操作
     * @param:
     * @return: void
     */
    private void listAllCustomers() {
        System.out.println("---------------------客户列表---------------------\n");

        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                System.out.println((i + 1) + "\t" + custs[i].getName() + "\t" + custs[i].getGender()
                        + "\t" + custs[i].getAge() + "\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
            }
        }

        System.out.println("---------------------客户列表---------------------\n");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
