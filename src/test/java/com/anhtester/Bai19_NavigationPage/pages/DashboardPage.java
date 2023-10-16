package com.anhtester.Bai19_NavigationPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'icon header-user-profile')]");
    private By optionLogout = By.xpath("//ul[@class='dropdown-menu animated fadeIn']//li[@class='header-logout']//a[@href='#'][normalize-space()='Logout']");

    public DashboardPage(WebDriver _driver){
        driver=_driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickMenuDashboard(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuDashboard));
        driver.findElement(menuDashboard).click();

    }

    public CustomerPage clickMenuCustomer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuCustomer));
        driver.findElement(menuCustomer).click();

        return  new CustomerPage(driver);

    }

    public void clickMenuProjects(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuProjects));
        driver.findElement(menuProjects).click();

    }

    public LoginPage logout(){
        driver.findElement(dropdownProfile).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLogout));
        driver.findElement(optionLogout).click();

        return new LoginPage(driver);

    }


}
