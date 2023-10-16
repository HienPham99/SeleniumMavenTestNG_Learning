package Bai17_POM.testCases;

import com.anhtester.Bai17_POM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccessWithAdmin(){
        loginPage= new LoginPage(driver); //Khởi tạo đối tượng class khác để lấy nó chấm gọi các hàm ở class này

        //Gọi hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded();//dùng ki chuển trang (load trang)
        loginPage.testLoginSuccess();

    }

    @Test
    public void testLoginWithEmailInvalid(){
        loginPage= new LoginPage(driver);
        //Gọi hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example123.com", "123456");
        loginPage.testLoginFail();

    }
}
