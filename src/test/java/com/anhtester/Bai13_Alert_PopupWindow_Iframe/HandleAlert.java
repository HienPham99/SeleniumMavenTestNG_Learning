package com.anhtester.Bai13_Alert_PopupWindow_Iframe;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {

    @Test (priority = 1)
    public void demoHandleAlertAccept(){
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Click btn[Click me!] thứ nhất. Hệ thống có ALERT chỉ có 1 btn OK
        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[1]")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        sleep(2);
    }

    @Test(priority = 2)
    public void demoHandleAlertDismiss(){

        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Click btn[Click me!]. Hệ thống có ALERT chỉ có 1 btn OK
        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
        sleep(1);

        //Khởi tạo class Alert và hàm handle với Slert
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();

        WebElement messageDismiss = driver.findElement(By.xpath("//p[@id='confirm-demo']"));
        Assert.assertTrue(messageDismiss.isDisplayed(), "Message chưa hiển thị");
        System.out.println(messageDismiss.getText());
        Assert.assertEquals(messageDismiss.getText(), "You pressed Cancel!", "Message not match");
        sleep(2);
    }

    @Test
    public void demoHandleAlertInputText(){
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(1);

        driver.findElement(By.xpath("(//div[normalize-space()='Java Script Alert Box'])[2]/following-sibling::div/button")).click();
        sleep(1);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Rất vui với Automatic");
        sleep(2);
        alert.accept();

        WebElement messageInputText= driver.findElement(By.xpath("//p[@id='prompt-demo']"));

        Assert.assertTrue(messageInputText.isDisplayed());
        System.out.println(messageInputText);
        Assert.assertEquals(messageInputText.getText(), "You have entered 'Rất vui với Automatic' !", "Text hiển thị chưa đúng");
        sleep(1);

    }
}
