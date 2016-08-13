package com.junit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * Created by Eric on 2016/8/8.
 */
public class Junit4Sample {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass,to be run once before any of the test methods in the class");
    }

    @Before
    public void before(){
        System.out.println("Before,to be run before the {@link org.junit.Test} method");
    }

    @Test
    public void testA(){
        System.out.println("Test,can be run as a test case");
    }

    @Test
    public void testB(){
        System.out.println("Test,can be run as a test case");
    }

    @After
    public void after(){
        System.out.println("After，to be run after the {@link org.junit.Test} method");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass,to be run after all the tests in the class have been run");
    }
}
