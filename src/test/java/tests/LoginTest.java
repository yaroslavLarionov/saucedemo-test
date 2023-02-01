package tests;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Before
    public void localSetUp() {
        loginPage = new LoginPage(getDriver());
    }

   @Test
    public void userLogin() {
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
