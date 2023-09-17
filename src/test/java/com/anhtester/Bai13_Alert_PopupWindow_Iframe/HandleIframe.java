package com.anhtester.Bai13_Alert_PopupWindow_Iframe;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIframe extends BaseTest {

    @Test
    public void iFrame01()  {

        driver.navigate().to("https://anhtester.com/contact");
        sleep(10);
        //In tổng số iframe của hệ thống
        System.out.println("Iframe total: " + driver.findElements(By.tagName("iframe")).size());
        sleep(1);
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Chuyển hướng iframe đầu tiên và thực hiện thao tác trên iframe
        System.out.println("Header của Iframe: " + driver.findElement(By.tagName("strong")).getText());
        System.out.println("Message: " + driver.findElement(By.xpath("//body")).getText());
        sleep(2);
        driver.findElement(By.tagName("span")).click(); //click btn chat
        sleep(2);

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Trở về content chính (Không thuộc iframe nào cả)

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        sleep(2);
    }

}
