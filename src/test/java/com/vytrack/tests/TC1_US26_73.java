package com.vytrack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC1_US26_73 {

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
    //    Verify the users see 8 modules: Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System
    @Test
    public void loginToPage(){
        WebElement usernameInput = driver.findElement(By.id("prependedInput"));
        usernameInput.sendKeys("storemanager95");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();

        WebElement LInk1 = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        System.out.println("LInk1.isDisplayed() = " + LInk1.isDisplayed());


        WebElement LInk2 = driver.findElement(By.xpath("(//a[@class='unclickable'])[2]"));
        System.out.println("LInk2.isDisplayed() = " + LInk2.isDisplayed());


        WebElement LInk3 = driver.findElement(By.xpath("(//a[@class='unclickable'])[3]"));
       System.out.println("LInk3.isDisplayed() = " + LInk3.isDisplayed());
//
//
//
        WebElement LInk4 = driver.findElement(By.xpath("(//a[@class='unclickable'])[4]"));
        System.out.println("LInk4.isDisplayed() = " + LInk4.isDisplayed());
//
//
//
        WebElement LInk5 = driver.findElement(By.xpath("(//a[@class='unclickable'])[5]"));
        System.out.println("LInk5.isDisplayed() = " + LInk5.isDisplayed());
//
//
//
        WebElement LInk6 = driver.findElement(By.xpath("(//a[@class='unclickable'])[6]"));
//        System.out.println("LInk6.isDisplayed() = " + LInk6.isDisplayed());
//
//
//
        WebElement LInk7 = driver.findElement(By.xpath("(//a[@class='unclickable'])[7]"));
        System.out.println("LInk7.isDisplayed() = " + LInk7.isDisplayed());
//
//
//
        WebElement LInk8 = driver.findElement(By.xpath("//li[@class='mobile-hide dropdown dropdown-level-1 last']"));
        System.out.println("LInk8.isDisplayed() = " + LInk8.isDisplayed());

        }


    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}



