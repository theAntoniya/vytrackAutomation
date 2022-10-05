package Tests;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.WebDriverFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SelectVehicle {


    private Map<String, String> UserNameAndPassword = new HashMap<>();
    WebDriver driver;


    public Map<String, String> getUserNameAndPassword() {
        return UserNameAndPassword;
    }

    public void setUserNameAndPassword(Map<String, String> userNameAndPassword) {
        UserNameAndPassword = userNameAndPassword;
    }


    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void TestCase1() throws InterruptedException {

        setUserNameAndPassword(Map.of("storemanager95", "UserUser123", "storemanager98", "UserUser123"));
        for (Map.Entry<String, String> each : getUserNameAndPassword().entrySet()) {

//            User enters user name and password. Then click Login

            WebElement sendUserN = driver.findElement(By.xpath("//input[@id='prependedInput']"));
            sendUserN.sendKeys(each.getKey());
            WebElement sendPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
            sendPassword.sendKeys(each.getValue() + Keys.ENTER);
            System.out.println(each.getKey());
            Thread.sleep(1000);


//          User clicks the Vehicle Button  under the Fleet Tab
            WebElement FleetDropDown = driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]"));
            FleetDropDown.click();
            Thread.sleep(1500);
            WebElement VehiclesBtn = driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"));
            VehiclesBtn.click();
            Thread.sleep(1500);


//            Verify all the checkboxes are unchecked

            List<WebElement> clickAllBox = driver.findElements(By.xpath("//td//input[@type='checkbox']"));
            boolean unchecked = false;
            int actualCount = 0;
            int expectedCount = clickAllBox.size();


            for (WebElement allBox : clickAllBox) {
                actualCount++;
                if (allBox.isSelected()) {
                    unchecked = false;
                    System.out.println("failed!!there is a selected checkbox");
                    break;
                }
            }


            Assert.assertTrue(actualCount == expectedCount, "FAILED!!!there is some checked  checkbox");

            Thread.sleep(1000);
//            Log out Codes

            WebElement logout = driver.findElement(By.xpath("//a[@href='javascript: void(0);']"));
            logout.click();
            WebElement logout2 = driver.findElement(By.xpath("//a[@href='/user/logout']"));
            logout2.click();
            Thread.sleep(1000);
        }
        driver.quit();
    }


    @Test
    public void TestCase2() throws InterruptedException {

        setUserNameAndPassword(Map.of("storemanager95", "UserUser123"));

        for (Map.Entry<String, String> each : getUserNameAndPassword().entrySet()) {

//            User enters user name and password. Then click Login

            WebElement sendUserN = driver.findElement(By.xpath("//input[@id='prependedInput']"));
            sendUserN.sendKeys(each.getKey());
            WebElement sendPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
            sendPassword.sendKeys(each.getValue() + Keys.ENTER);
            System.out.println(each.getKey());
            Thread.sleep(2000);


//          User clicks the Vehicle Button  under the Fleet Tab
            WebElement FleetDropDown = driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]"));
            FleetDropDown.click();
            Thread.sleep(2000);
            WebElement VehiclesBtn = driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']"));
            VehiclesBtn.click();
            Thread.sleep(1000);

//          User clicks the first checkbox in the web-table
            WebElement firstCheckbox = driver.findElement(By.xpath("//div//button[@class='btn btn-default btn-small dropdown-toggle']/input"));
            firstCheckbox.click();

//          Verify all the checkbox also checked

            List<WebElement> clickAllBox = driver.findElements(By.xpath("//td//input[@type='checkbox']"));

            boolean areAllCheckboxesSelected = true;
            int countSelected = 0;

            for (WebElement allBox : clickAllBox) {
                countSelected++;
                if (!allBox.isSelected()) {
                    areAllCheckboxesSelected = false;
                    break;
                }
            }
            Assert.assertEquals(countSelected, clickAllBox.size());

//         Log out
            WebElement logout = driver.findElement(By.xpath("//a[@href='javascript: void(0);']"));
            logout.click();
            WebElement logout2 = driver.findElement(By.xpath("//a[@href='/user/logout']"));
            logout2.click();
            Thread.sleep(1000);

        }
        driver.quit();


    }
    @Test
    public void TestCase3(){
        setUserNameAndPassword(Map.of("storemanager95", "UserUser123"));

        for (Map.Entry<String, String> each : getUserNameAndPassword().entrySet()) {


        }

    }
}