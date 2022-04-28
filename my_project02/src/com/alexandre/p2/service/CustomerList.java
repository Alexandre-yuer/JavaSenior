package com.alexandre.p2.service;

import com.alexandre.p2.bean.Customer;

/**
 * @ClassName CustomerList
 * @Description: CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 * @Author: alexandre
 * @Date: 2022/4/28 15:16
 */

public class CustomerList {

    private Customer[] customers;   //用来保存客户对象的数组
    private int total = 0;          //记录已保存客户对象的数量

    /***
     * @description: 用来初始化customer数组的构造器
     * @param: totalCustomer
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * @description: 将指定的客户添加到数组中
     * @param: customer
     * @return: true:添加成功 false:添加失败
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * @description: 修改指定索引位置的客户信息
     * @Param index
     * @Param cust
     * @return: true:修改成功 false:修改失败
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * @description: 删除指定索引位置上的客户
     * @param: index
     * @return: true:删除成功 false:删除失败
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

        //最后有数据的元素需要置空
        customers[total - 1] = null;
        total--;
        return true;
    }

    /**
     * @description: 获取所有客户的信息
     * @param:
     * @return: com.alexandre.p2.bean.Customer[]
     */
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * @description: 获取指定索引位置上的客户
     * @param: index
     * @return: 如果找到了元素，则返回；如果没有找到，则返回null
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
     * @description: 获取存储客户的数量
     * @param:
     * @return: int
     */

    public int getTotal() {
        return total;
    }
}


