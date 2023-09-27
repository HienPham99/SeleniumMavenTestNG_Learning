package com.anhtester.Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavasriptExcutor extends BaseTest {

    @Test
    public void testJavasriptExcutor01() {
        driver.get("https://cms.anhtester.com/");
        sleep(1);

        WebElement btnCloseWellcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement subMenuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement btnViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement btnApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));


        //sử dụng hàm của Selenium ể thao tác thông thường
        //btnCloseWellcomeDialog.click();
//      subMenuBlogs.click();
        //btnViewAllCategories.click();
        //btnApplyNow.click();

        //Sử dụng JAVASCRIPT EXCUTOR để thực hiện click sub_Menu blogs bị CHE bởi 1 phần tử khác
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click;", subMenuBlogs); //click vào element cần thao tác (subMenuBlogs)


    }

    @Test
    public void testJavasriptExcutor02() {
        driver.get("https://cms.anhtester.com/");
        sleep(1);

        WebElement btnCloseWellcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement subMenuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement btnViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement btnApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));


        //sử dụng hàm của Selenium để thao tác thông thường
        btnCloseWellcomeDialog.click();

        //Sử dụng JAVASCRIPT EXCUTOR để thực hiện click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));
        js.executeScript("arguments[0].setAttribute('value','Qua tet');", inputSearch);//input "Quà tet"vào field Search
        sleep(2);
    }

    @Test
    public void testJavasriptExcutor03() {
        driver.get("https://cms.anhtester.com/");
        sleep(1);
        WebElement btnCloseWellcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement subMenuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement btnViewAllCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement btnApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));

        btnCloseWellcomeDialog.click();
        sleep(1);

        //Sử dụng JAVASCRIPT EXCUTOR để thực hiện click
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scrollIntoView(true): Cuộn chuôt đến vị trí Top(btn ở trên) của phần tử Btn Apply NowbtnViewAllCategories
        js.executeScript("arguments[0].scrollIntoView(true);", btnViewAllCategories);
        //Tô Màu viền cho element (tô màu xanh lá)
        js.executeScript("arguments[0].style.border='3px solid Green'", btnViewAllCategories);
        btnViewAllCategories.click();

        // scrollIntoView(False): Cuộn chuôt đến vị trí Bottom (btn ở dưới) của phần tử Btn Apply NowbtnViewAllCategories
        // js.executeScript("arguments[0].scrollIntoView(false);", btnViewAllCategories);
        // btnViewAllCategories.click();

        //Lấy kích thước màn hình
//        System.out.println(js.executeScript("return window.innerHight;").toString());
//        System.out.println(js.executeScript("return window.innerWidth;").toString());

        sleep(2);
    }
}
