package com.anhtester.Bai19_NavigationPage.testCases;

import com.anhtester.Bai19_NavigationPage.pages.CustomerPage;
import com.anhtester.Bai19_NavigationPage.pages.DashboardPage;
import com.anhtester.Bai19_NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(driver);
        dashboardPage=loginPage.loginCRM("admin@example.com","123456");

        //Click menu Customer
        customerPage= dashboardPage.clickMenuCustomer();  //Xảy ra chuyên trang

        //Chuyen sang trang Customer
        customerPage.clickButtonAddNew();


    }
}
