package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {

    //Khai báo đối tượng SoftAssert
//    SoftAssert softAssert = new SoftAssert();
//
//    @AfterClass //Không sử dụng trường hợp này vì TH này báo lỗi chung chung
//    public void assertAllCases() {
//        softAssert.assertAll();
//    }

    @Test
    public void testLoginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Khai báo đối tượng SoftAssert
        SoftAssert softAssert = new SoftAssert(); //NÊN khao báo SoftAssert và assertAll ở từng @Test (TCs) để hệ thống chạy báo lỗi Ró RÀNG minh bạch chi tiết TCs nào bị lỗi

        //Assert header với text của nó
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        softAssert.assertEquals(header, "Login123", "Giá trị header sai."); //So sánh bằng

        boolean checkButtonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        softAssert.assertTrue(checkButtonLogin, "Button Login không được bật");

        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        softAssert.assertTrue(menuName.contains("Customer"), "Giá trị menu name không chứa giá trị mong muốn: " + menuName); //So sánh chứa thông qua java

        softAssert.assertAll(); //Tổng kết lại tất cả các trường hợp Fail.NÊN khai báo SoftAssert và assertAll ở từng @Test (TCs) để hệ thống chạy báo lỗi chi tiết TCs nào bị lỗi
    }

    @Test
    public void testLoginCRM2() {
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Khai báo đối tượng SoftAssert
         SoftAssert softAssert = new SoftAssert();


        //Assert header với text của nó
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        softAssert.assertEquals(header, "Login", "Giá trị header sai."); //So sánh bằng

        boolean checkButtonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        softAssert.assertTrue(checkButtonLogin, "Button Login không được bật");

        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        softAssert.assertTrue(menuName.contains("Customer"), "Gi trị menu name không chứa giá trị mong muốn: " + menuName); //So sánh chứa thông qua java

        softAssert.assertAll(); //Tổng kết lại tất cả các trường hợp Fail
    }

}
