package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {

    @Test
    public void testLoginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Assert header với text của nó
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        Assert.assertEquals(header, "Login", "Giá trị header sai."); //So sánh bằng

        boolean checkButtonLogin= driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        Assert.assertTrue(checkButtonLogin, "Button Login không được bật");

        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        sleep(2);
        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        Assert.assertTrue(menuName.contains("Customer123"), "Giá trị menu name không chứa giá trị mong muốn: " + menuName); //So sánh chứa thông qua java
    }

}
