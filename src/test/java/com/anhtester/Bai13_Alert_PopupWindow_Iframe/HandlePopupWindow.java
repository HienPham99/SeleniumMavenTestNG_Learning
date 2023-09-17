package com.anhtester.Bai13_Alert_PopupWindow_Iframe;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopupWindow extends BaseTest {

    @Test
    public void demoPopupTypeTab(){

        driver.get("https://demoqa.com/browser-windows");
        sleep(1);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(2);

        //Lưu lại mã ID Window đầu tiên (main window)
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        //Lấy tất cả các mã định danh Tab Window (các tab window con)
        Set<String> windows = driver.getWindowHandles();
        //sử dụng SET (LIST lấy tất cả phần tử, cả trùng nhau) là Collection để lưu các phần tử có giá trị KHÔNG trùng nhau
        //Duyệt từng phần tử:
        //*CÁCH 1: duyệt = FOR (Hạn cế dùng)

//        for (String window : windows ){
//            System.out.println(window); //in domain của all window ra
//            //So sánh tab mới nếu không pải là tab chính(Main window) thì chuyển hướng đến tab mới đó và thực hiện thao tác trên tab mới
//            if (!mainWindow.equals(window)){
//                //Chuyển hướng đến Tab mới (Tab con)
//                driver.switchTo().window(window);
//                sleep(1);
//                System.out.println("Đã chuyển đến tab window mới.");
//
//                //Một số hàm hỗ trợ
//                System.out.println(driver.switchTo().window(window).getTitle());
//                System.out.println(driver.switchTo().window(window).getCurrentUrl());
//
//                sleep(1);
//                //Sau khi chuyển hướng sang Tab mới thì getText cái header
//                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
//
//                // Tắt cái Tab Window mới.
//                sleep(1);
//                driver.close();
//            }
//        }
        //*CÁCH 2: Duyệt = ARRAY (Nên dùng)
        String window1 = windows.toArray()[0].toString();//Đây là Cửa sổ đầu tiên (Main window. vị trí [0])
        String window2 = windows.toArray()[1].toString();//cửa sổ con tiếp theo (vị trí thứ 2 [1])

        driver.switchTo().window(window2); //chuyển hướng đến cửa sổ cần thao tác (cửa sổ thứ 2) và bắt đầu thực hiện all thao tác trên window thứ 2 này

        System.out.println("Domain của window 2 là: " + driver.switchTo().window(window2).getCurrentUrl());
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        sleep(1);

        driver.close(); //Thoát/tắt cửa sổ con.

        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
    }
}
