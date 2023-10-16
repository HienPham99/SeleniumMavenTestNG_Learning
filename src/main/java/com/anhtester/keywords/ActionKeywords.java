package com.anhtester.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ActionKeywords {

    private  static WebDriver driver;

    public  ActionKeywords(WebDriver driver){
        this.driver = driver;
    }

    public static  void clickElement(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public static  void setText(String locator, String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    //Hàm chờ đợi trang load xong
    public static void waitForPageLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30),Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it Ready
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            }catch (Throwable error){
                error.printStackTrace();
                Assert.fail("Failed. Timeout waiting for page load");

            }
        }

    }
}
