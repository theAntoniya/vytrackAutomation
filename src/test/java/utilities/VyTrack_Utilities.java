package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack_Utilities {


    public static void logInVyTrack(WebDriver driver,String userName,String password){
        WebElement userNameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userNameBox.sendKeys(userName);
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordBox.sendKeys(password);
        WebElement logInBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        logInBtn.click();
    }



}


