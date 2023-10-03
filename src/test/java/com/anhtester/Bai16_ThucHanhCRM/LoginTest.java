package com.anhtester.Bai16_ThucHanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorCRM;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccess() {
        driver.get(InfoCRM.URL);
        waitForPageLoaded();//chờ trang load xong
        SoftAssert softAssert = new SoftAssert();
        //Kiểm tra title/header của page Login đúng hay sai
        softAssert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header Login không hiển thị.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).getText(), "Login", "Header Login page not match");
        //Thực hiện hành động login
        setText(LocatorCRM.inputEmail, InfoCRM.Email);
        setText(LocatorCRM.inputPassword, InfoCRM.Password);
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        //Kiểm tra đường dẫn domain có chính xác sau khi login ko
        //1. Check Không pải URL của page Login dùng assertFailse
        boolean checkURLNotAuthen = driver.getCurrentUrl().contains("authentication");
        Assert.assertFalse(checkURLNotAuthen);
        //2. Check xem Page sau khi login có chứa "admin" trên URL (Domain) ko
        boolean checkURLContainDashboard = driver.getCurrentUrl().contains("admin");
        Assert.assertTrue(checkURLContainDashboard,"Không phải URL (domain) của trang dashboard.");
        //System.out.println("Domain sau khi login: " + checkURLContainDashboard);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Không phải trang Dasboard.");

        softAssert.assertAll();
    }

    @Test
    public void testLoginWithEmailInvalid() {

        driver.get(InfoCRM.URL);
        waitForPageLoaded();//chờ trang load xong
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header Login không hiển thị.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).getText(), "Login", "Header Login page not match");
        setText(LocatorCRM.inputEmail, "123@gmail.com");
        setText(LocatorCRM.inputPassword, InfoCRM.Password);
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        boolean checkURLNotAuthen = driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURLNotAuthen);
        //check Error message hiển thị
        Assert.assertTrue(checkElementExits(LocatorCRM.alertMessage), "Fail,không hiển thị error message");
        //C1: kiểm tra khi chưa viết hàm GetText chung bên BaseTest
       // Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.alertMessage)).getText(), "Invalid email or password ", "Error message not match.";
        //C2: sau khi viết hàm getText chung bên BaseTest
        Assert.assertEquals(getTextElement(LocatorCRM.alertMessage), "Invalid email or password","Error message not match.");
        Assert.assertFalse(checkElementExits(LocatorCRM.menuDashboard), "Fail, Đây là trang Dasboard."); //Kiểm tra element cần đến (Menu dashboard) có xuất hiện ko
        //Assert.assertTrue(driver.findElements(By.xpath(LocatorCRM.menuDashboard)).size() > 0, "Không phải trang Dasboard.");

        softAssert.assertAll();

    }

    @Test
    public void testLoginWithPasswordInvalid() {

        driver.get(InfoCRM.URL);
        waitForPageLoaded();//chờ trang load xong
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header Login không hiển thị.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).getText(), "Login", "Header Login page not match");
        setText(LocatorCRM.inputEmail, InfoCRM.Email);
        setText(LocatorCRM.inputPassword, "17890");
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();
        //Hàm kiểm tra URL chứa gì
        boolean checkURLNotAuthen = driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURLNotAuthen); //muốn ko chứa dùng assertFalse
        //Hàm kiểm tra error message hiển thị
        Assert.assertTrue(checkElementExits(LocatorCRM.alertMessage), "Fail,không hiển thị error message");
        //Hàm kiểm tra error message có chính xác ko
        Assert.assertEquals(getTextElement(LocatorCRM.alertMessage), "Invalid email or password","Error message not match.");
        //Hàm kiểm tra header page vẫn tồn tại
        Assert.assertTrue(checkElementExits(LocatorCRM.headerLoginPage), "Fail, Header Login không tồn tại.");
        //Hàm kiểm tra login ko thành công thì ko đến được trang Dashboard
        Assert.assertFalse(checkElementExits(LocatorCRM.menuDashboard), "Fail, Đây là trang Dasboard."); //Kiểm tra element cần đến (Menu dashboard) có xuất hiện ko
        softAssert.assertAll();

    }
}
