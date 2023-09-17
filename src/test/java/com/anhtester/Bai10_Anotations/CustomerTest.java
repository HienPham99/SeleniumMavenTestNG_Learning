package com.anhtester.Bai10_Anotations;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    @Test (priority = 1, description = "Add customers successfully")
    public void testAddCustomers(){
        //Login
        //Mở menu
        //Mở form addCustomer
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

    }

    @Test (priority = 2, description = "Add customers successfully")
    public void testFilterCustomers(){
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

    }

    @Test (priority = 3, description = "Add customers successfully")
    public void testAddCustomersDuplicated(){
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

    }

    @Test (priority = 4, description = "Add customers successfully")
    public void testEditCustomers(){
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

    }

    @Test (priority = 5, description = "Add customers successfully")
    public void testDeleteCustomers(){
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

    }


    public void testAddCustomersFlow(){
        //Mở menu

        //Mở form addCustomer
    }



}
