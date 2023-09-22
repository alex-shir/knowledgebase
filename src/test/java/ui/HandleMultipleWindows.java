package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleMultipleWindows {
    public static String browser = "Chrome"; // config XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/bootcamp/index.php");
        driver.findElement(By.cssSelector("a[class=\"ws-btn w3-mobile applynowbtn ga-featured\"]")).click();
        Thread.sleep(4000);
        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println(windowhandles);

        Iterator<String> iterator = windowhandles.iterator();
        String parentwindow = iterator.next();
        String childwindow = iterator.next();

        driver.switchTo().window(childwindow);
        driver.findElement(By.id("filter-Price-0-from")).sendKeys("100");
        driver.switchTo().window(parentwindow);
    }
}
