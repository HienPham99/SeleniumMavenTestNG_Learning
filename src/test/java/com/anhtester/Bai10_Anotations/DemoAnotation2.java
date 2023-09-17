package com.anhtester.Bai10_Anotations;

import org.testng.annotations.*;

public class DemoAnotation2 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suites");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suites");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeGroups (groups = {"testOne"})
    public void beforeGroupsOne() {
        System.out.println("Before groups one");
    }

    @AfterGroups (groups = {"testOne"})
    public void afterGroupsOne() {
        System.out.println("After groups test one");
    }

    @BeforeGroups(groups = {"testTwo"})
    public void beforeGroupsTwo() {
        System.out.println("Before groups Testwo");
    }

    @AfterGroups(groups = {"testTwo"})
    public void afterGroupsTwo() {
        System.out.println("After groups Testwo");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

    @Test(groups={ "testOne"}, priority = 1)
    public void testOneMethod() {
        System.out.println("Test method 5");
    }

    @Test(groups={ "testTwo"}, priority =2)
    public void testTwoMethod() {
        System.out.println("Test method 6");
    }

    @Test(groups={ "testOne"},priority= 3)
    public void testThreeMethod() {
        System.out.println("Test method 7");
    }

    @Test(groups={ "testTwo"}, priority=4)
    public void testFourMethod() {
        System.out.println("Test method 8");
    }

}
