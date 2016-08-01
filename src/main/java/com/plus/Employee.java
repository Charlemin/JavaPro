package com.plus;

import java.security.PublicKey;

/**
 * Created by Administrator on 2016/7/24 0024.
 */

class Person{
    int i;
    String id;
    public Person(){}
    public Person(String id){
        this.id = id;
    }

}
public class Employee extends Person {
    String fsdgf;
    public Employee(String id){
        super(id);
    }


    public static void main(String[] args) {
        Employee employee = new Employee("vdsv");
        System.out.println(employee.i);
    }
}
