package testcases;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import org.testng.Assert;

public class LoginTest extends BaseClass {
	LoginPage login;
	HomePage home;

    @Test
    public void verifyLogin() throws Exception {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        HomePage home = new HomePage(driver);
        String user = home.getLoggedInUser();

        Assert.assertTrue(user.contains("Admin"), "Login failed!");
        System.out.println("✅ Login Test Passed - User: " + user);
    }
}