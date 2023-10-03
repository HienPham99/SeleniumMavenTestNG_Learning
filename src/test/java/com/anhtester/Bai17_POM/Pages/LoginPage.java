package com.anhtester.Bai17_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");

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

    }

    public void loginCRM(String email, String password){
        driver.get("https://crm.anhtester.com/admin/authentication");
//        driver.findElement(inputEmail).sendKeys(email);
//        driver.findElement(inputPassword).sendKeys(password);
//        driver.findElement(buttonLogin).click();
        setEmail(email);
        setPassword(password);
        clickLoginButton();

    }

}
