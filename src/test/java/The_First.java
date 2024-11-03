import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class The_First {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://demo.guru99.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("emailid")).sendKeys("usedtokeep@rom.vn");
        driver.findElement(By.name("btnLogin")).click();
        String username = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
        String password = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText();
        driver.get("https://demo.guru99.com/test/login.html");
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).submit();
    }
}
