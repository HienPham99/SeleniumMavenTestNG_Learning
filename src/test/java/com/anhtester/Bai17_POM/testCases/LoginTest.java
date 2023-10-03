package com.anhtester.Bai17_POM.testCases;

import com.anhtester.Bai17_POM.Pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage= new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

    }
}
