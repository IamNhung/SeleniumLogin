import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT_Excel {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Khai báo đường dẫn đến file Excel
        String filePath = "C:\\Users\\Administrator\\Downloads\\datatest.xlsx";

        // Đọc dữ liệu từ file Excel
        ArrayList<String[]> loginData = readExcelData(filePath);

        driver.get("https://demo.guru99.com/test/login.html");
    // Duyệt qua từng dòng dữ liệu trong file Excel
        for (String[] credentials : loginData) {
        String username = credentials[0];
        String password = credentials[1];

        // Tìm và nhập username, password
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("SubmitLogin"));
        loginButton.click();

        driver.navigate().back();
    }

        driver.quit();
}

    private static ArrayList<String[]> readExcelData(String filePath) {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            int numberOfRows = sheet.getLastRowNum();
            System.out.println(numberOfRows);

            for (int i = 1; i <= numberOfRows; i++) {
                Row row = sheet.getRow(i);
                if(row.getCell(0).getStringCellValue() != null && row.getCell(1).getStringCellValue() != null) {
                    String username = row.getCell(0).getStringCellValue();
                    String password = row.getCell(1).getStringCellValue();
                    data.add(new String[]{username, password});
                }
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
