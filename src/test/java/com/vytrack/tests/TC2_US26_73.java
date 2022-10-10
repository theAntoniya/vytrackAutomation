package com.vytrack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC2_US26_73 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Set up browser
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa1.vytrack.com/user/login");
    }

    //    login as a salesmanager or storemanagers
    //    Verify the users see 4 modules: Fleet, Customers, Activities, System
    @Test
    public void loginToPage() {
        WebElement usernameInput = driver.findElement(By.id("prependedInput"));
        usernameInput.sendKeys("user184");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();


        WebElement LInk1 = driver.findElement(By.xpath("(//a[@class='unclickable'])[1]"));
       System.out.println("LInk1.isDisplayed() = " + LInk1.isDisplayed());


        WebElement LInk2 = driver.findElement(By.xpath("(//a[@class='unclickable'])[2]"));
        System.out.println("LInk2.isDisplayed() = " + LInk2.isDisplayed());


        WebElement LInk3 = driver.findElement(By.xpath("(//a[@class='unclickable'])[3]"));
       System.out.println("LInk3.isDisplayed() = " + LInk3.isDisplayed());
//
//

        WebElement LInk4 = driver.findElement(By.xpath("(//a[@class='unclickable'])[4]"));
       System.out.println("LInk4.isDisplayed() = " + LInk4.isDisplayed());
//
//

    }}