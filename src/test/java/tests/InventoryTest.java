package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InventoryTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
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


