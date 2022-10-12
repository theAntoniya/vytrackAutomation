package com.vytrack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TS26_72 {

    private WebDriver webDriver;

    private HashMap<String, String> credentials;

    private void login(String username, String password) {
        // login the page
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://qa2.vytrack.com/user/login");

        var usernameElement = webDriver.findElement(By.id("prependedInput"));
        usernameElement.sendKeys(username);

        var passwordElement = webDriver.findElement(By.id("prependedInput2"));
        passwordElement.sendKeys(password);

        var loginButtonElement = webDriver.findElement(By.id("_submit"));
        loginButtonElement.click();
    }

    private void setCredentials() {
        credentials = new HashMap<>();
        credentials.put("user184", "UserUser123");
    }

    @BeforeMethod
    public void setUp() {
        // initialize a chrome web driver
        webDriver = WebDriverFactory.getDriver("chrome");

        // navigate to the url
        webDriver.get("https://qa2.vytrack.com");

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // handle credentials
        setCredentials();

        // handle login operation
        login("user184", credentials.get("user184"));
    }

    @Test
    public void test_oroinc_link_exists_and_clickable(){

        // locate the oroinc link
        var oroincLinkElement  = webDriver.findElement(By.xpath("//a[@href='http://www.oroinc.com/doc']"));
        oroincLinkElement.click();
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }
}
