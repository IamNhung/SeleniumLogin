/*
package config;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {
    public static WebDriver driver;
    public static String username;
    public static String password;
    public static void open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void navigate_RegisPage(){
        driver.get("https://demo.guru99.com/");
    }

    public static void enter_Email(){
        driver.findElement(By.name("emailid")).sendKeys("usedtokeep@rom.vn");
    }

    public static void click_Submit(){
        driver.findElement(By.name("btnLogin")).click();
    }

    public static void catch_Username(){
        username = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
    }
    public static void catch_Password(){
        password = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText();
    }

    public static void navigate_LoginPage(){
        driver.get("https://demo.guru99.com/test/login.html");
    }

    public static void enter_Username(){
        driver.findElement(By.id("email")).sendKeys(username);
    }
    public static void enter_Password(){
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public static void click_SignIn(){
        driver.findElement(By.id("SubmitLogin")).submit();
    }

    public static void closeBrowser(){
        driver.quit();
    }

}*/
/*package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {
    public static WebDriver driver;
    public static String username;
    public static String password;
    public static void open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public static void navigate_RegisPage(){
        driver.get(Constants.URL);
    }
    public static void enter_Email(){
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys(Constants.email);
    }
    public static void click_Submit(){
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
    }
    public static void catch_Username(){
        username = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
    }
    public static void catch_Password(){
        password = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText();
    }

    public static void navigate_LoginPage(){
        driver.get(Constants.URL2);
    }

    public static void enter_Username(){
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
    }
    public static void enter_Password(){
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
    }

    public static void click_SignIn(){
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).submit();
    }

    public static void closeBrowser(){
        driver.quit();
    }
}*/
package config;
import static executionEngine.DriverScript.OR;
import executionEngine.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Log;

public class ActionKeywords {
        public static WebDriver driver;
        public static String username;
        public static String password;

        public static void open_Browser(String object) {
            try {
                WebDriverManager.chromedriver().setup();
                Log.info("Open browser");
                driver = new ChromeDriver();
            }catch(Exception e){
                Log.info("Not able to open browser" + e.getMessage());
                DriverScript.bResult = false;
            }
        }
        public static void navigate_RegisPage(String object) {
            try {
                Log.info("Navigate regisPage");
                driver.get(Constants.URL);
            }catch(Exception e){
                Log.info("Not able to Navigate regisPage" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void enter_Email(String object) {
            try {
                Log.info("Enter regisPage");
                driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.email);
            }catch(Exception e){
                Log.info("Not able to Enter regisPage" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void click(String object) {
            try {
                Log.info("Click ");
                driver.findElement(By.xpath(OR.getProperty(object))).click();
            }catch(Exception e){
                Log.info("Not able to Click" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void catch_Username(String object) {
            try {
                Log.info("Catch username ");
                username = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
            }catch(Exception e){
                Log.info("Not able to Catch username" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void catch_Password(String object) {
            try {
                Log.info("Catch password ");
                password = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText();
            }catch(Exception e) {
                Log.info("Not able to Catch password" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void navigate_LoginPage(String object) {
            try {
                Log.info("Navigate to login page");
                driver.get(Constants.URL2);
            }catch(Exception e){
                Log.info("Not able to login page" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void enter_Username(String object) {
            try {
                Log.info("Enter username");
                driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(username);
            }catch(Exception e){
                Log.info("Not able to Enter username" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void enter_Password(String object) {
            try {
                Log.info("Enter password");
                driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(password);
            }catch(Exception e){
                Log.info("Not able to Enter password" + e.getMessage());
                DriverScript.bResult = false;
            }
        }

        public static void closeBrowser(String object) {
            try {
                Log.info("Close browser");
                driver.quit();
            }catch(Exception e){
                Log.info("Not able to Close browser " + e.getMessage());
                DriverScript.bResult = false;
            }
        }
}
