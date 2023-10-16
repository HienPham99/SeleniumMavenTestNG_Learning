package com.anhtester.Bai19_NavigationPage.testCases;

import com.anhtester.Bai19_NavigationPage.pages.DashboardPage;
import com.anhtester.Bai19_NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoginSuccessWithAdmin(){
        loginPage= new LoginPage(driver); //Khởi tạo đối tượng class khác để lấy nó chấm gọi các hàm ở class này

        //Gọi hàm xử lý có sẵn để sử dụng
        dashboardPage= loginPage.loginCRM("admin@example.com", "123456");
        dashboardPage.clickMenuCustomer();
        waitForPageLoaded();//dùng ki chuển trang (load trang)
        loginPage.testLoginSuccess();

        dashboardPage.logout();

    }

    }
