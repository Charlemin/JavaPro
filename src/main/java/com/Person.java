package com;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>ClassName: Person<p>
 * <p>Description:测试对象序列化和反序列化<p>
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 下午02:33:25
 */
public class Person implements Comparable<Person> , Serializable{

    public static void main(String[] args) {
        Person person1 = new Person(23,"zhamin","male");
        Person person2 = new Person(25,"zhamin2","male");

        List<Person> personList = Arrays.asList(person1,person2);
        Collections.sort(personList);
        for (Person person : personList)
            System.out.println(person.toString());

//        Integer a = 12;
//        Integer b = 12;
//        Integer c = new Integer(12);
//        Integer d = new Integer(12);
//        System.out.println(a == b);
//        System.out.println(c == d);
    }
    /**
     * 序列化ID
     */
    //private static final long serialVersionUID = -5809782578272943999L;
    private int age;

    private String name;
    private String sex;

    @Override
    public int compareTo(Person o1) {
        if (o1.age > this.age)
            return 1;
        else if(o1.age < this.age)
                return -1;
        return 0;
    }

    public Person(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}