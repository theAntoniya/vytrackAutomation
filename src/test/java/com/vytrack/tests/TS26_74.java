package com.vytrack.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TS26_74 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test

    public void InfoPageValidation () {

        driver.get("https://qa1.vytrack.com/user/login");


        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName.sendKeys("salesmanager263");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passWord.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"_submit\"]"));
        loginButton.click();


        driver.get("https://qa1.vytrack.com/");


        WebElement clickButton = driver.findElement(By.xpath("//*[@class='fa-question-circle']"));
        clickButton.click();

    }
    public void tearDown (){

        driver.quit();
    }
}

