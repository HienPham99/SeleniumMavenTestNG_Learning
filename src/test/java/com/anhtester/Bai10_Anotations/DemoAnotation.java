package com.anhtester.Bai10_Anotations;

import com.anhtester.common.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.*;

public class DemoAnotation extends BaseTest {
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

    @Test(groups={ "testOne"}, priority = 1, description = "Đây là testcase đầu tiên")
    public void testOneMethod() {
        System.out.println("Test method 1");
    }

    @Test(groups={ "testTwo"}, priority =2,description = "Check log test description")
    public void testTwoMethod() {
        System.out.println("Test method 2");
    }

    @Test(groups={ "testOne"},priority= 3, description = "Tester Phạm Thị Hiền ")
    public void testThreeMethod() {
        System.out.println("Test method 3");
    }

    @Test(groups={ "testTwo"}, priority=4, description = "QA_Hiền PT")
    public void testFourMethod() {
        System.out.println("Test method 4");
    }

}
