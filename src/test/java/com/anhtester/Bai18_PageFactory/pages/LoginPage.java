package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.constants.ConfigData;
import com.anhtester.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    //Khai báo driver cục bộ trong chính class
    private WebDriver driver;
    private WebDriverWait wait;

    //* Khai báo dạng POM thuần
    // private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    //private By inputEmail = By.xpath("//input[@id='email']");
    //private By inputPassword = By.xpath("//input[@id='password']");
    //private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    //private By errorMessage = By.xpath("//div[@id='alerts']");

    //* Khai báo dạng PageFactory
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    WebElement headerPage;

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement buttonLogin;

    @FindBy(xpath = "//div[@id='alerts']")
    WebElement errorMessage;

    //Khai báo nhiều đối tượng element
    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']"))
    List<WebElement> listMenu;

    //Khai báo 1 đối tượng bằng nhiều cách định vị lấy element (điều kiện HOẶC: hoặc tìm theo xpath này, hoặc tìm theo xpath kia)
    @FindAll({@FindBy(xpath = "//span[normalize-space()='Customers']"), @FindBy(xpath = "//ul[@id='side-menu']/li[3]")})
    WebElement menuCustomer;


    //Khởi tạo hàm xây dựng để truyền driver từ bên ngoài vào chính class này để sử dụng
    public LoginPage(WebDriver _driver) {
        driver = _driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //***Khởi tạo giá trị cho các đối tượng webElement bên trên (THỰC THI TÌM KIẾM_BẮT BUỘC)***
        PageFactory.initElements(driver, this);

    }

    private void setEmail(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        //driver.findElement(inputEmail).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email);

    }

    private void setPassword(String password) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        // driver.findElement(inputPassword).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(password);

    }

    private void clickLoginButton() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        // driver.findElement(buttonLogin).click();
        wait.until(ExpectedConditions.visibilityOf(buttonLogin));
        buttonLogin.click();
    }

    //In nhiều element ra màn hình
    private void getMenuList() {
        for (WebElement menu : listMenu) {
            System.out.println(menu.getText());

        }
    }

    public void testLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL, vẫn ở trang Login.");

    }

    public void testLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message NOT display");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Fail. Constaint of Error message NOT match.");
    }

    //Hàm xử lý chính
    public void loginCRM(String email, String password) {
        driver.get(ConfigData.URL);
        setEmail(email);
        setPassword(password);
        clickLoginButton();
       // ActionKeywords.waitForPageLoaded();
        getMenuList();
        menuCustomer.click();

    }

}
