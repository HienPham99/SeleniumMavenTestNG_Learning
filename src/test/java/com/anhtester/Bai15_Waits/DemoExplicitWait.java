package com.anhtester.Bai15_Waits;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait extends BaseTest {

//    @Test
//    public void testExplicitWait01() {
//
//        driver.get("https://hrm.anhtester.com/");
//
//        //Set timeout
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        //Login hrm
//        driver.findElement(By.id("iusername")).sendKeys("admin_example");
//        driver.findElement(By.id("ipassword")).sendKeys("123456");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        //Click menu project
//        //Chờ element Projects hiển thị -> click element projects
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Projects']")));
//        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
//
//        driver.findElement(By.xpath("//a[@class='btn btn-sm waves-effect waves-light btn-primary btn-icon m-0']")).click();
//        //Set chờ cho element load/hiển thị thì mới thực hiện set text (sendkeys)
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
//        driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Anh tester");

//    }
@Test(priority = 1)
public void testExplicitWait01() {

    driver.get("https://hrm.anhtester.com/");

    //Set timeout for WebDriverWait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //Login
    driver.findElement(By.id("iusername")).sendKeys("admin_example");
    driver.findElement(By.id("ipassword")).sendKeys("123456");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    //sleep(6);

    //Chờ đợi menu Project visible(hiển thị) rồi mới click
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));
    driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

}

    @Test(priority = 2)
    public void testExplicitWait02() {

        driver.get("https://hrm.anhtester.com/");

        //Set timeout for WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        driver.findElement(By.xpath("//a[@class='collapsed btn waves-effect waves-light btn-primary btn-sm m-0']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Anh Tester");

        //wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Title']"))));

    }
}


