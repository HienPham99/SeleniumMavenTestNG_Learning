package com.anhtester.Bai10_Anotations;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Login CRM successfully")
    public void testLoginSuccess(){

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }

    @Test (priority = 2, description = "Add customers successfully")
    public void testAddCustomers(){
        testLoginSuccess();//Goi lại phần auto Test case Login từ Testcase testLoginSuccess ở trên(Điều kiện CLASS "BASETEST" pải sử dụng annotation là "BeforeMETHOD-AfterMETHOD" chứ ko dùng "BeforeClass/Test".
        // Nếu dùng BeforeClass/Test thì ko gọi lại TCs testLoginSuccess vì bị trùng(ko thể lồng TCs vào TCs khi dùng beforeTest/Class.
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();



    }



}
