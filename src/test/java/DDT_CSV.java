import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DDT_CSV {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String csvFile = "C:\\Users\\Administrator\\Downloads\\Book1.csv";
        String line;
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(cvsSplitBy);
                String username = data[0];
                String password = data[1];
                System.out.println(line);

                driver.get("https://demo.guru99.com/test/login.html");
                WebElement emailField = driver.findElement(By.id("email"));
                emailField.clear(); // Đảm bảo trường không bị ghi đè
                emailField.sendKeys(username);
                WebElement passwordField = driver.findElement(By.id("passwd"));
                passwordField.clear(); // Đảm bảo trường không bị ghi đè
                passwordField.sendKeys(password);
                WebElement loginButton = driver.findElement(By.id("SubmitLogin"));
                loginButton.click();

                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}