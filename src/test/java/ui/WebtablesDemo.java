package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebtablesDemo {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.investing.com/");

        //Step 1 - Switch to frame wich has that particular table
        // Step 2 - Get the number of rows
        // Step 3 - Get the number of columns
        // Step 4 - iterate rows and columns and get text and print it

        List<WebElement> rowlements = driver.findElements(By.xpath("//*[@id=\"side_central_banks\"]/table/tbody/tr"));
        System.out.println(rowlements.size());
        int rowsize = rowlements.size();
        List<WebElement> columnlements = driver.findElements(By.xpath("//*[@id=\"side_central_banks\"]/table/tbody/tr[1]/td"));
        System.out.println(columnlements.size());
        int columnsize = columnlements.size();
// явное ожидание PoPuP
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PromoteSignUpPopUp\"]/div[2]/i"))).click();
        for (int i = 1; i <= rowsize; i++) {
            for (int j = 1; j <= columnsize; j++) {
                System.out.print(driver.findElement(By.xpath("//*[@id=\"side_central_banks\"]/table/tbody/tr[" + i + "]/td[" + j + "]")).getText());
            }
            System.out.println();
        }
    }
}
