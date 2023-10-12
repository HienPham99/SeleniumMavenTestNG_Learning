package com.anhtester.Bai17_POM.pages;

import com.anhtester.constants.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    //Khai báo driver cục bộ trong chính class
    private WebDriver driver;
    private WebDriverWait wait;

     //khai báo các element dạng đối tượng By (Phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    //Khởi tạo hàm xây dựng để truyền driver từ bên ngoài vào chính class này để sử dụng
    public  LoginPage(WebDriver _driver){
       // this driver = driver;
        driver= _driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private void setEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);

    }

    private void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void testLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL, vẫn ở trang Login.");

    }

    public  void testLoginFail(){
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT display");
        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Invalid email or password", "Fail. Constaint of Error message NOT match.");


    }

    //Hàm ử lý chính
    public void loginCRM(String email, String password){
        driver.get(ConfigData.URL); //gọi từ class ConfigData của package "constants"
//        driver.findElement(inputEmail).sendKeys(email);
//        driver.findElement(inputPassword).sendKeys(password);
//        driver.findElement(buttonLogin).click();
        setEmail(email);
        setPassword(password);
        clickLoginButton();

    }

}
